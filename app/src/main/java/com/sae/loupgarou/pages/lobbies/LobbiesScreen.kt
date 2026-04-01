package com.sae.loupgarou.pages.lobbies

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sae.loupgarou.models.Lobby
import com.sae.loupgarou.pages.Retour
import com.sae.loupgarou.viewmodel.LobbiesViewModel

@Composable
fun LobbiesScreen(
    onNavigateBack: () -> Unit,
    onCreateLobby: () -> Unit,
    onLobbyClick: () -> Unit,
    onReturn: () -> Unit,
    viewModel: LobbiesViewModel
) {
    var selectedFilter by remember { mutableStateOf("all") }

    // On écoute le flux de données venant du ViewModel
    val allLobbies by viewModel.lobbies.collectAsState()

    // Logique de filtrage basée sur le champ 'phase' ou 'isEnded' de ton modèle Lobby
    val filteredLobbies = remember(allLobbies, selectedFilter) {
        when (selectedFilter) {
            "all" -> allLobbies
            "ended" -> allLobbies.filter { it.isEnded || it.phase == "ended" }
            else -> allLobbies.filter { it.phase == selectedFilter }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundLobbies()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            HeaderLobbies()
            ActionButtons(
                onCreateLobby = onCreateLobby,
                onRefresh = { viewModel.fetchLobbies() }
            )

            Retour(onReturn)

            Filters(selectedFilter = selectedFilter, onFilterChange = { selectedFilter = it })
            LobbiesContent(filteredLobbies = filteredLobbies, onLobbyClick = onLobbyClick)

        }
    }
}