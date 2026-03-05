package com.sae.loupgarou.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sae.loupgarou.data.SessionManager
import com.sae.loupgarou.models.LoginRequest
import com.sae.loupgarou.services.AuthApiService
import com.sae.loupgarou.services.RetrofitClient
import kotlinx.coroutines.launch

class LoginViewModel @JvmOverloads constructor(
    application: Application,
    private val apiService: AuthApiService = RetrofitClient.authApiService
) : AndroidViewModel(application) {
    
    private val sessionManager = SessionManager(application)
    
    var isLoading by mutableStateOf(false)
    var loginResult by mutableStateOf<String?>(null)

    fun login(email: String, mdp: String) {
        viewModelScope.launch {
            isLoading = true
            loginResult = null
            try {
                val response = apiService.login(LoginRequest(email, mdp))
                if (response.isSuccessful) {
                    val body = response.body()
                    val token = body?.token
                    if (token != null) {
                        sessionManager.saveToken(token)
                        loginResult = "Succès : Connexion réussie"
                    } else {
                        loginResult = "Erreur : Token non reçu"
                    }
                } else {
                    loginResult = "Erreur : ${response.code()} - Identifiants incorrects"
                }
            } catch (e: Exception) {
                loginResult = "Erreur réseau : ${e.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }
}