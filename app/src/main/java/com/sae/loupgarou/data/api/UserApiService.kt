package com.sae.loupgarou.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Header
import com.sae.loupgarou.models.User
import com.sae.loupgarou.models.PreviousGame

interface UserApiService {

    @GET("users/me")
    suspend fun getUserMe(@Header("Authorization") token: String): User

    @GET("previousGames/{login}")
    suspend fun getPreviousGames(@Path("login") login: String): List<PreviousGame>

}
