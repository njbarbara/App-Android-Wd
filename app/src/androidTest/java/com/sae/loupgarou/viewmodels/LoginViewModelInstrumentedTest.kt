package com.sae.loupgarou.viewmodels

import android.app.Application
import android.os.SystemClock
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.sae.loupgarou.data.SessionManager
import com.sae.loupgarou.models.LoginRequest
import com.sae.loupgarou.models.LoginResponse
import com.sae.loupgarou.models.RegisterRequest
import com.sae.loupgarou.models.RegisterResponse
import com.sae.loupgarou.services.AuthApiService
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Response

@RunWith(AndroidJUnit4::class)
class LoginViewModelInstrumentedTest {

    private lateinit var application: Application
    private lateinit var sessionManager: SessionManager

    @Before
    fun setUp() = runBlocking {
        application =
            InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as Application
        sessionManager = SessionManager(application)
        sessionManager.clearSession()
    }

    @After
    fun tearDown() = runBlocking {
        sessionManager.clearSession()
    }

    @Test
    fun login_withSuccessfulResponse_marksSuccessAndPersistsToken() = runBlocking {
        val apiService = FakeAuthApiService(
            loginHandler = {
                Response.success(LoginResponse(token = "jwt-token", message = "ok"))
            }
        )
        val viewModel = LoginViewModel(application, apiService)

        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            viewModel.login(login = "najib", password = "secret")
        }
        waitUntil { !viewModel.isLoading && viewModel.loginResult != null }

        assertTrue(viewModel.isSuccess)
        assertEquals("jwt-token", sessionManager.getToken())
        assertNotNull(viewModel.loginResult)
        assertEquals(LoginRequest(login = "najib", password = "secret"), apiService.lastLoginRequest)
    }

    @Test
    fun login_withHttpError_keepsUserDisconnected() = runBlocking {
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

        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            viewModel.login(login = "najib", password = "wrong-password")
        }
        waitUntil { !viewModel.isLoading && viewModel.loginResult != null }

        assertFalse(viewModel.isSuccess)
        assertNull(sessionManager.getToken())
        assertTrue(viewModel.loginResult?.contains("401") == true)
    }

    private fun waitUntil(
        timeoutMs: Long = 2_000,
        condition: () -> Boolean
    ) {
        val endTime = SystemClock.elapsedRealtime() + timeoutMs
        while (!condition()) {
            if (SystemClock.elapsedRealtime() >= endTime) {
                fail("Condition was not met within $timeoutMs ms")
            }
            InstrumentationRegistry.getInstrumentation().waitForIdleSync()
            Thread.sleep(25)
        }
    }

    private class FakeAuthApiService(
        private val loginHandler: suspend (LoginRequest) -> Response<LoginResponse>,
        private val registerHandler: suspend (RegisterRequest) -> Response<RegisterResponse> = {
            Response.success(RegisterResponse(token = "unused", message = "unused"))
        }
    ) : AuthApiService {

        var lastLoginRequest: LoginRequest? = null
            private set

        override suspend fun login(request: LoginRequest): Response<LoginResponse> {
            lastLoginRequest = request
            return loginHandler(request)
        }

        override suspend fun register(request: RegisterRequest): Response<RegisterResponse> {
            return registerHandler(request)
        }
    }
}
