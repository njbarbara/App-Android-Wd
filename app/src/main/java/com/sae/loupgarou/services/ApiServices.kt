package com.sae.loupgarou.services

import com.sae.loupgarou.models.Game
import com.sae.loupgarou.models.LoginRequest
import com.sae.loupgarou.models.LoginResponse
import com.sae.loupgarou.models.PreviousGame
import com.sae.loupgarou.models.RegisterRequest
import com.sae.loupgarou.models.RegisterResponse
import com.sae.loupgarou.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiServices {
    @POST("/api/auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("/api/auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    @GET("/api/users/me")
    suspend fun getUserMe(@Header("Authorization") token: String): Response<User>

    @GET("/api/games")
    suspend fun getGames(@Header("Authorization") token: String): Response<List<Game>>

    @GET("/api/previousGames/{login}")
    suspend fun getPreviousGames(
        @Header("Authorization") token: String,
        @Path("login") login: String
    ): Response<List<PreviousGame>>
}
