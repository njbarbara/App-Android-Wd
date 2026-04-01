package com.sae.loupgarou.viewmodels

import com.sae.loupgarou.models.LoginRequest
import com.sae.loupgarou.models.LoginResponse
import com.sae.loupgarou.models.RegisterRequest
import com.sae.loupgarou.models.RegisterResponse
import com.sae.loupgarou.services.AuthApiService
import retrofit2.Response

internal class FakeAuthApiService(
    private val loginHandler: suspend (LoginRequest) -> Response<LoginResponse> = {
        Response.success(LoginResponse(token = "unused-login-token", message = "ok"))
    },
    private val registerHandler: suspend (RegisterRequest) -> Response<RegisterResponse> = {
        Response.success(RegisterResponse(token = "unused-register-token", message = "ok"))
    }
) : AuthApiService {

    var lastLoginRequest: LoginRequest? = null
        private set

    var lastRegisterRequest: RegisterRequest? = null
        private set

    override suspend fun login(request: LoginRequest): Response<LoginResponse> {
        lastLoginRequest = request
        return loginHandler(request)
    }

    override suspend fun register(request: RegisterRequest): Response<RegisterResponse> {
        lastRegisterRequest = request
        return registerHandler(request)
    }
}

@Suppress("UNCHECKED_CAST")
internal fun <T> nullBodyResponse(): Response<T> =
    Response.success(null) as Response<T>
