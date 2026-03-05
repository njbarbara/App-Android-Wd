package com.sae.loupgarou.services

import com.sae.loupgarou.models.LoginRequest
import com.sae.loupgarou.models.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("/api/users")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}