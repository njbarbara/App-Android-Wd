package com.sae.loupgarou.data.api

import retrofit2.http.GET
import com.sae.loupgarou.models.User

interface UserApiService {

        //et on fait passer le token dans le body
        @GET("users/me")
        suspend fun getUsers(): User



        /* //Template d'appel Post pour plus tard
        @POST("posts")
        suspend fun createPost(@Body post: Post): Post
         */

}