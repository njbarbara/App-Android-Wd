package com.sae.loupgarou.pages.historique

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.sae.loupgarou.models.Game

@Composable
fun RecentGames(games: List<Game>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(games) { game ->
            GameTemplate(
                heureDeCreation = game.heureDeCreation,
                gameResult = game.result,
                nightCounts = game.nightCounts
            )
        }
    }
}
