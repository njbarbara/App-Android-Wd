package com.sae.loupgarou.data.api

// data/api/ApiService.kt
import com.sae.loupgarou.models.Lobby
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("lobbies")
    suspend fun getLobbies(): List<Lobby>

    /* //Template d'appel Post pour plus tard
    @POST("posts")
    suspend fun createPost(@Body post: Post): Post
     */
}