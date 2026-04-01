package com.sae.loupgarou.pages.historique

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.sae.loupgarou.models.PreviousGame

@Composable
fun RecentGames(games: List<PreviousGame>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(games) { game ->
            GameTemplate(
                gameDate = game.gameDate,
                gameResult = game.result,
                rolePlayed = game.rolePlayed,
                nightsCount = game.nightsCount
            )
        }
    }
}
