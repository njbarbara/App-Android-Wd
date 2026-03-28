package com.sae.loupgarou.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sae.loupgarou.data.SessionManager
import com.sae.loupgarou.models.RegisterRequest
import com.sae.loupgarou.services.ApiServices
import com.sae.loupgarou.services.RetrofitClient
import kotlinx.coroutines.launch

class RegisterViewModel @JvmOverloads constructor(
    application: Application,
    private val apiService: ApiServices = RetrofitClient.apiServices
) : AndroidViewModel(application) {

    private val sessionManager = SessionManager(application)
    var isLoading by mutableStateOf(false)
    var registerResult by mutableStateOf<String?>(null)
    var isSuccess by mutableStateOf(false)
        private set

    fun register(login: String, email: String, password: String) {
        viewModelScope.launch {
            isLoading = true
            registerResult = null
            isSuccess = false
            try{
                val response = apiService.register(RegisterRequest(login, password, email))
                if (response.isSuccessful) {
                    val body = response.body()
                    val token = body?.token
                    if (token != null) {
                        sessionManager.saveSession(token, login)
                        registerResult = "Succès : Inscription réussie"
                        isSuccess = true
                    }
                }else {
                    registerResult = "Erreur : ${response.code()} -Erreur inconnue - Inscription échouée"
                }
            }catch(e: Exception){
                registerResult = "Erreur réseau : ${e.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }
}
