package com.sae.loupgarou.viewmodels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.sae.loupgarou.data.SessionManager
import com.sae.loupgarou.models.Game
import com.sae.loupgarou.services.RetrofitClient
import kotlinx.coroutines.launch

class HistoriqueViewModel(application: Application) : AndroidViewModel(application) {
    private val sessionManager = SessionManager(application)

    var games by mutableStateOf<List<Game>>(emptyList())
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
                val login = sessionManager.getLogin()
                if (login != null) {
                    // On filtre les stubs pour ne garder que les parties où l'utilisateur est présent
                    games = Game.stubs.filter { game ->
                        game.players.any { it.username == login }
                    }
                    
                    if (games.isEmpty()) {
                        errorMessage = "Aucune partie trouvée pour l'utilisateur $login"
                    }
                } else {
                    errorMessage = "Utilisateur non connecté"
                    games = emptyList()
                }
            } catch (e: Exception) {
                errorMessage = "Erreur : ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
}
