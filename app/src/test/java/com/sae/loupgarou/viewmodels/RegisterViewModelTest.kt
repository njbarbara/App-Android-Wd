package com.sae.loupgarou.viewmodels

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.sae.loupgarou.data.SessionManager
import com.sae.loupgarou.models.RegisterRequest
import com.sae.loupgarou.models.RegisterResponse
import com.sae.loupgarou.testutils.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import retrofit2.Response

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
@OptIn(ExperimentalCoroutinesApi::class)
class RegisterViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var application: Application
    private lateinit var sessionManager: SessionManager

    @Before
    fun setUp() = runBlocking {
        application = ApplicationProvider.getApplicationContext()
        sessionManager = SessionManager(application)
        sessionManager.clearSession()
    }

    @After
    fun tearDown() = runBlocking {
        sessionManager.clearSession()
    }

    @Test
    fun register_withSuccessfulResponse_marksSuccessAndPersistsToken() =
        runTest(mainDispatcherRule.dispatcher.scheduler) {
            val apiService = FakeAuthApiService(
                registerHandler = {
                    Response.success(RegisterResponse(token = "jwt-token", message = "ok"))
                }
            )
            val viewModel = RegisterViewModel(application, apiService)

            viewModel.register(login = "najib", email = "najib@example.com", password = "secret")
            advanceUntilIdle()
            waitUntil { !viewModel.isLoading }

            assertTrue(viewModel.isSuccess)
            assertFalse(viewModel.isLoading)
            assertEquals("jwt-token", sessionManager.getToken())
            assertTrue(viewModel.registerResult?.contains("Inscription") == true)
            assertEquals(
                RegisterRequest(login = "najib", password = "secret", email = "najib@example.com"),
                apiService.lastRegisterRequest
            )
        }

    @Test
    fun register_withMissingBody_doesNotPersistToken() =
        runTest(mainDispatcherRule.dispatcher.scheduler) {
            val apiService = FakeAuthApiService(
                registerHandler = {
                    nullBodyResponse()
                }
            )
            val viewModel = RegisterViewModel(application, apiService)

            viewModel.register(login = "najib", email = "najib@example.com", password = "secret")
            advanceUntilIdle()
            waitUntil { !viewModel.isLoading }

            assertFalse(viewModel.isSuccess)
            assertFalse(viewModel.isLoading)
            assertNull(sessionManager.getToken())
            assertNull(viewModel.registerResult)
        }

    @Test
    fun register_withHttpError_reportsFailureCode() =
        runTest(mainDispatcherRule.dispatcher.scheduler) {
            val apiService = FakeAuthApiService(
                registerHandler = {
                    Response.error(
                        409,
                        """{"message":"Conflict"}"""
                            .toResponseBody("application/json".toMediaType())
                    )
                }
            )
            val viewModel = RegisterViewModel(application, apiService)

            viewModel.register(login = "najib", email = "najib@example.com", password = "secret")
            advanceUntilIdle()
            waitUntil { !viewModel.isLoading }

            assertFalse(viewModel.isSuccess)
            assertFalse(viewModel.isLoading)
            assertNull(sessionManager.getToken())
            assertTrue(viewModel.registerResult?.contains("409") == true)
        }

    @Test
    fun register_withNetworkError_reportsExceptionMessage() =
        runTest(mainDispatcherRule.dispatcher.scheduler) {
            val apiService = FakeAuthApiService(
                registerHandler = {
                    throw IllegalStateException("service down")
                }
            )
            val viewModel = RegisterViewModel(application, apiService)

            viewModel.register(login = "najib", email = "najib@example.com", password = "secret")
            advanceUntilIdle()
            waitUntil { !viewModel.isLoading }

            assertFalse(viewModel.isSuccess)
            assertFalse(viewModel.isLoading)
            assertNull(sessionManager.getToken())
            assertTrue(viewModel.registerResult?.contains("service down") == true)
        }

    private fun waitUntil(
        timeoutMs: Long = 2_000,
        condition: () -> Boolean
    ) {
        val endTime = System.currentTimeMillis() + timeoutMs
        while (!condition()) {
            if (System.currentTimeMillis() >= endTime) {
                fail("Condition was not met within $timeoutMs ms")
            }
            Thread.sleep(25)
        }
    }
}
