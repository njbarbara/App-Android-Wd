package com.sae.loupgarou.viewmodel

import com.example.example_project.data.api.ApiService
import com.sae.loupgarou.data.api.UserApiService

class ProfileViewModel(
    private val api: UserApiService // C'est la qu'on instancie le service API
) {


    init {
        fetchProfileInfo()
    }

    fun fetchProfileInfo(){

    }
}