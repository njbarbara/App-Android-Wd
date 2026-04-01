package com.sae.loupgarou.data.api

import com.sae.loupgarou.data.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://2.3.196.39:3000/api/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Lazy initialization : l'objet n'est créé que lorsqu'on en a besoin
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    val userApiService: UserApiService by lazy {
        retrofit.create(UserApiService::class.java)
    }
}
