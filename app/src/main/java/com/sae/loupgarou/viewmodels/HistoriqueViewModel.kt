package com.sae.loupgarou.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sae.loupgarou.data.SessionManager
import com.sae.loupgarou.models.PreviousGame
import com.sae.loupgarou.services.RetrofitClient
import kotlinx.coroutines.launch

class HistoriqueViewModel(application: Application) : AndroidViewModel(application) {
    private val sessionManager = SessionManager(application)

    var previousGames by mutableStateOf<List<PreviousGame>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun fetchGames() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                val token = sessionManager.getToken()
                if (token == null) {
                    errorMessage = "Utilisateur non connecté"
                    return@launch
                }

                val authHeader = "Bearer $token"
                
                // 1. Récupérer les infos de l'utilisateur courant (me)
                val userResponse = RetrofitClient.apiServices.getUserMe(authHeader)
                
                if (userResponse.isSuccessful) {
                    val login = userResponse.body()?.username
                    if (login != null) {
                        // 2. Récupérer l'historique avec le login obtenu
                        val gamesResponse = RetrofitClient.apiServices.getPreviousGames(authHeader, login)
                        
                        if (gamesResponse.isSuccessful) {
                            previousGames = gamesResponse.body() ?: emptyList()
                            if (previousGames.isEmpty()) {
                                errorMessage = "Aucune partie trouvée"
                            }
                        } else {
                            errorMessage = "Erreur historique : ${gamesResponse.code()}"
                        }
                    } else {
                        errorMessage = "Impossible de récupérer le login"
                    }
                } else {
                    errorMessage = "Erreur session : ${userResponse.code()}"
                }
            } catch (e: Exception) {
                errorMessage = "Erreur : ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
}
