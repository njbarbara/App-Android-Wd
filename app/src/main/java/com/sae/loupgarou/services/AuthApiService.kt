package com.sae.loupgarou.services

import com.sae.loupgarou.models.LoginRequest
import com.sae.loupgarou.models.LoginResponse
import com.sae.loupgarou.models.RegisterRequest
import com.sae.loupgarou.models.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("/api/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("/api/auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>
}
