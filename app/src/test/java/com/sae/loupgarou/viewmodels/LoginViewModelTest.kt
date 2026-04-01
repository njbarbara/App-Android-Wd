package com.sae.loupgarou.viewmodels

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import com.sae.loupgarou.data.SessionManager
import com.sae.loupgarou.models.LoginRequest
import com.sae.loupgarou.models.LoginResponse
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
class LoginViewModelTest {

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
    fun login_withSuccessfulResponse_marksSuccessAndPersistsToken() =
        runTest(mainDispatcherRule.dispatcher.scheduler) {
            val apiService = FakeAuthApiService(
                loginHandler = {
                    Response.success(LoginResponse(token = "jwt-token", message = "ok"))
                }
            )
            val viewModel = LoginViewModel(application, apiService)

            viewModel.login(login = "najib", password = "secret")
            advanceUntilIdle()
            waitUntil { !viewModel.isLoading }

            assertTrue(viewModel.isSuccess)
            assertFalse(viewModel.isLoading)
            assertEquals("jwt-token", sessionManager.getToken())
            assertTrue(viewModel.loginResult?.contains("Connexion") == true)
            assertEquals(LoginRequest(login = "najib", password = "secret"), apiService.lastLoginRequest)
        }

    @Test
    fun login_withMissingBody_reportsMissingToken() =
        runTest(mainDispatcherRule.dispatcher.scheduler) {
            val apiService = FakeAuthApiService(
                loginHandler = {
                    nullBodyResponse()
                }
            )
            val viewModel = LoginViewModel(application, apiService)

            viewModel.login(login = "najib", password = "secret")
            advanceUntilIdle()
            waitUntil { !viewModel.isLoading }

            assertFalse(viewModel.isSuccess)
            assertFalse(viewModel.isLoading)
            assertNull(sessionManager.getToken())
            assertTrue(viewModel.loginResult?.contains("Token non") == true)
        }

    @Test
    fun login_withHttpError_keepsUserDisconnected() =
        runTest(mainDispatcherRule.dispatcher.scheduler) {
            val apiService = FakeAuthApiService(
                loginHandler = {
                    Response.error(
                        401,
                        """{"message":"Unauthorized"}"""
                            .toResponseBody("application/json".toMediaType())
                    )
                }
            )
            val viewModel = LoginViewModel(application, apiService)

            viewModel.login(login = "najib", password = "wrong-password")
            advanceUntilIdle()
            waitUntil { !viewModel.isLoading }

            assertFalse(viewModel.isSuccess)
            assertFalse(viewModel.isLoading)
            assertNull(sessionManager.getToken())
            assertTrue(viewModel.loginResult?.contains("401") == true)
        }

    @Test
    fun login_withNetworkError_reportsExceptionMessage() =
        runTest(mainDispatcherRule.dispatcher.scheduler) {
            val apiService = FakeAuthApiService(
                loginHandler = {
                    throw IllegalStateException("service down")
                }
            )
            val viewModel = LoginViewModel(application, apiService)

            viewModel.login(login = "najib", password = "secret")
            advanceUntilIdle()
            waitUntil { !viewModel.isLoading }

            assertFalse(viewModel.isSuccess)
            assertFalse(viewModel.isLoading)
            assertNull(sessionManager.getToken())
            assertTrue(viewModel.loginResult?.contains("service down") == true)
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
