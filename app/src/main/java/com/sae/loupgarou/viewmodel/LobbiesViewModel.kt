package com.sae.loupgarou.viewmodel

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example_project.data.api.ApiService
import com.sae.loupgarou.model.Lobby
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sae.loupgarou.model.PlayerInfo

class LobbiesViewModel(
    private val api: ApiService // C'est la qu'on instancie le service API
) : ViewModel() {

    //Stub
    private val fakeLobbies = listOf(
        Lobby(
            id = 1,
            players = listOf(
                PlayerInfo(username = "najib"),
                PlayerInfo(username = "BoosterStrange")
            ),
            heureDeCreation = "2026-03-05T18:00:00Z",
            nom = "Le Village des Débutants",
            description = "Partie chill pour apprendre les règles.",
            phase = "lobby", // En attente
            nbPlayerMax = 8,
            isEnded = false
        ),
        Lobby(
            id = 2,
            players = listOf(
                PlayerInfo(username = "cyril"),
                PlayerInfo(username = "najib"),
                PlayerInfo(username = "BoosterStrange")
            ),
            heureDeCreation = "2026-03-05T17:30:00Z",
            nom = "Compétition Sanglante",
            description = "Micro obligatoire, pas de pitié.",
            phase = "playing", // En cours
            nbPlayerMax = 10,
            isEnded = false
        ),
        Lobby(
            id = 3,
            players = listOf(
                PlayerInfo(username = "cyril"),
                PlayerInfo(username = "najib")
            ),
            heureDeCreation = "2026-03-05T16:00:00Z",
            nom = "Partie de l'après-midi",
            description = "GG aux loups qui ont tout rasé.",
            phase = "ended", // Terminée
            nbPlayerMax = 12,
            isEnded = true
        )
    )

    //private val _lobbies = MutableStateFlow<List<Lobby>>(fakeLobbies)

    private val _lobbies = MutableStateFlow<List<Lobby>>(emptyList())
    val lobbies: StateFlow<List<Lobby>> = _lobbies.asStateFlow()

    init {
        fetchLobbies()
    }



    fun fetchLobbies() {
        // Version stubée
        //_lobbies.value = fakeLobbies


        viewModelScope.launch {
            try {
                //Try de récupérer les données depuis l'API
                val remoteLobbies = api.getLobbies()
                Log.i("SAE_LOUP_GAROU", "Salons reçus de l'API : $remoteLobbies")
                _lobbies.value = remoteLobbies
            } catch (e: Exception) {
                Log.w("Erreur lors de la récupération des données depuis l'API", e)
            }
        }
    }
}