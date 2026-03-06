package com.sae.loupgarou.pages.lobbies

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Assure-toi que ces imports correspondent bien à la structure de ton projet
import com.sae.loupgarou.R
import com.sae.loupgarou.models.Lobby
import com.sae.loupgarou.viewmodel.LobbiesViewModel

// --- VARIABLES GLOBALES (Couleurs et Polices) ---
val Cyan400 = Color(0xFF22D3EE)
val Cyan600 = Color(0xFF0891B2)
val Slate900 = Color(0xFF0F172A)
val Slate800 = Color(0xFF1E293B)

val fontAldrich = FontFamily(
    Font(R.font.aldrich_regular, FontWeight.Normal)
)

// ==========================================
// COMPOSANT PRINCIPAL
// ==========================================
@Composable
fun LobbiesScreen(
    onNavigateBack: () -> Unit = {},
    onCreateLobby: () -> Unit = {},
    viewModel: LobbiesViewModel // On passe le ViewModel en paramètre (c'est plus propre pour l'injection)
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
                onRefresh = { viewModel.fetchLobbies() } // Appel manuel à l'API
            )
            Filters(selectedFilter = selectedFilter, onFilterChange = { selectedFilter = it })
            LobbiesContent(filteredLobbies = filteredLobbies)
        }
    }
}

// ==========================================
// SOUS-COMPOSANTS
// ==========================================

@Composable
fun BackgroundLobbies() {
    // Le fond (Image + Filtre sombre)
    Image(
        painter = painterResource(id = R.drawable.earth), // Remplace par ton image
        contentDescription = stringResource(id = R.string.lobbies_background_desc),
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Slate900.copy(alpha = 0.85f))
    )
}

@Composable
fun HeaderLobbies() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = R.string.lobbies_title),
            fontFamily = fontAldrich,
            color = Color.White,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        Box(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .width(150.dp)
                .height(2.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color.Transparent, Cyan400, Color.Transparent)
                    )
                )
        )
        Text(
            text = stringResource(id = R.string.lobbies_subtitle),
            color = Cyan400.copy(alpha = 0.8f),
            fontSize = 14.sp,
            fontFamily = fontAldrich,
            modifier = Modifier.padding(bottom = 24.dp)
        )
    }
}

@Composable
fun ActionButtons(onCreateLobby: () -> Unit, onRefresh: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(bottom = 24.dp)
    ) {
        Button(
            onClick = onCreateLobby,
            shape = CutCornerShape(topStart = 12.dp, bottomEnd = 12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Cyan600)
        ) {
            Icon(Icons.Default.Add, contentDescription = "Créer", tint = Color.White)
            Spacer(Modifier.width(8.dp))
            Text("Créer un Lobby", fontFamily = fontAldrich, color = Color.White)
        }

        OutlinedButton(
            onClick = onRefresh,
            shape = CutCornerShape(topStart = 12.dp, bottomEnd = 12.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Slate800.copy(alpha = 0.8f)),
            border = BorderStroke(1.dp, Cyan600.copy(alpha = 0.5f))
        ) {
            Icon(Icons.Default.Refresh, contentDescription = "Actualiser", tint = Cyan400)
            Spacer(Modifier.width(8.dp))
            Text("Actualiser", fontFamily = fontAldrich, color = Cyan400)
        }
    }
}

@Composable
fun Filters(selectedFilter: String, onFilterChange: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(bottom = 24.dp)
    ) {
        FilterButton(stringResource(id = R.string.lobbies_filter_all), "all", selectedFilter, onFilterChange)
        FilterButton(stringResource(id = R.string.lobbies_filter_waiting), "lobby", selectedFilter, onFilterChange)
        FilterButton(stringResource(id = R.string.lobbies_filter_playing), "playing", selectedFilter, onFilterChange)
        FilterButton(stringResource(id = R.string.lobbies_filter_ended), "ended", selectedFilter, onFilterChange)
    }
}

@Composable
fun LobbiesContent(filteredLobbies: List<Lobby>) {
    if (filteredLobbies.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .background(Color.Black.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                .border(1.dp, Cyan600.copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(stringResource(id = R.string.lobbies_empty_emoji), fontSize = 40.sp, modifier = Modifier.padding(bottom = 16.dp))
                Text(stringResource(id = R.string.lobbies_empty_title), color = Color.White, fontSize = 18.sp, fontFamily = fontAldrich)
                Text(stringResource(id = R.string.lobbies_empty_subtitle), color = Cyan400, fontSize = 14.sp)
            }
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            // On utilise "items" correctement avec la data class Lobby
            items(filteredLobbies) { lobby ->
                LobbyCard(lobby)
            }
        }
    }
}

@Composable
fun FilterButton(text: String, filterValue: String, currentFilter: String, onClick: (String) -> Unit) {
    val isSelected = filterValue == currentFilter
    val bgColor = if (isSelected) Cyan600.copy(alpha = 0.8f) else Slate800.copy(alpha = 0.6f)
    val textColor = if (isSelected) Color.White else Cyan400

    Box(
        modifier = Modifier
            .clickable { onClick(filterValue) }
            .background(bgColor, RoundedCornerShape(4.dp))
            .border(
                1.dp,
                if (isSelected) Color.Transparent else Cyan600.copy(alpha = 0.3f),
                RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = textColor, fontFamily = fontAldrich, fontSize = 12.sp)
    }
}

@Composable
fun LobbyCard(lobby: Lobby) {
    val statusColor = when {
        lobby.isEnded || lobby.phase == "ended" -> Color.Gray
        lobby.phase == "lobby" -> Cyan400
        lobby.phase == "playing" -> Color(0xFFF59E0B)
        else -> Color.Gray
    }

    Box(
        modifier = Modifier
            .background(Slate900.copy(alpha = 0.9f), CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp))
            .border(1.dp, statusColor.copy(alpha = 0.5f), CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp))
            .clickable { /* TODO: Naviguer vers les détails du salon */ }
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = lobby.nom ?: "Salon #${lobby.id}",
                color = Color.White,
                fontFamily = fontAldrich,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${lobby.playerCount} / ${lobby.nbPlayerMax} Joueurs",
                    color = Color.LightGray,
                    fontSize = 12.sp
                )
                Text(
                    text = lobby.phase.uppercase(),
                    color = statusColor,
                    fontSize = 10.sp,
                    fontFamily = fontAldrich,
                    modifier = Modifier
                        .background(statusColor.copy(alpha = 0.1f), RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                )
            }
        }
    }
}