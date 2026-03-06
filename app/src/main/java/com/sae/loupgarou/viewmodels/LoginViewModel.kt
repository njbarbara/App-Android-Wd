package com.sae.loupgarou.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sae.loupgarou.data.SessionManager
import com.sae.loupgarou.models.LoginRequest
import com.sae.loupgarou.models.RegisterRequest
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
    var registerResult by mutableStateOf<String?>(null)


    fun login(login: String, password: String) {
        viewModelScope.launch {
            isLoading = true
            loginResult = null
            try {
                val response = apiService.login(LoginRequest(login, password))
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
                    val errorBody = response.errorBody()?.string()
                    var errorMessage = "Identifiants incorrects" // Message par défaut
                    loginResult = "Erreur : ${errorBody ?: errorMessage} - Identifiants incorrects"
                }
            } catch (e: Exception) {
                loginResult = "Erreur réseau : ${e.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }

    fun register(login: String, email: String, password: String) {
        viewModelScope.launch {
            isLoading = true
            registerResult = null
            try{
                val response = apiService.register(RegisterRequest(login, email, password))
                if (response.isSuccessful) {
                    val body = response.body()
                    val token = body?.token
                    if (token != null) {
                        sessionManager.saveToken(token)
                        registerResult = "Succès : Inscription réussie"
                    } else {
                        registerResult = "Erreur : Token non reçu"
                    }
                }
            }catch(e: Exception){
                registerResult = "Erreur réseau : ${e.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }
}

