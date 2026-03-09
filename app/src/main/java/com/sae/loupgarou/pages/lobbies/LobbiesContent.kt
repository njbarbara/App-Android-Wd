package com.sae.loupgarou.pages.lobbies

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R
import com.sae.loupgarou.R.color
import com.sae.loupgarou.model.Lobby
import com.sae.loupgarou.fontAldrich

@Composable
fun LobbiesContent(filteredLobbies: List<Lobby>) {
    if (filteredLobbies.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
                .background(Color.Black.copy(alpha = 0.4f), RoundedCornerShape(8.dp))
                .border(1.dp, colorResource(id = color.Cyan600).copy(alpha = 0.3f), RoundedCornerShape(8.dp))
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(stringResource(id = R.string.lobbies_empty_emoji), fontSize = 40.sp, modifier = Modifier.padding(bottom = 16.dp))
                Text(stringResource(id = R.string.lobbies_empty_title), color = Color.White, fontSize = 18.sp, fontFamily = fontAldrich)
                Text(stringResource(id = R.string.lobbies_empty_subtitle), color = colorResource(id = color.Cyan400), fontSize = 14.sp)
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