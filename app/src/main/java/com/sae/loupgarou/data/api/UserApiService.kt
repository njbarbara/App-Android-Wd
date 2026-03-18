package com.sae.loupgarou.data.api

import com.sae.loupgarou.model.Lobby
import retrofit2.http.GET
import com.sae.loupgarou.model.User
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {

        //et on fait passer le token dans le body
        @GET("users/me")
        suspend fun getUsers(): User

        /* //Template d'appel Post pour plus tard
        @POST("posts")
        suspend fun createPost(@Body post: Post): Post
         */

}