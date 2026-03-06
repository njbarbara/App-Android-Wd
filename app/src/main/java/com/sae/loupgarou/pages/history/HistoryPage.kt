package com.sae.loupgarou.pages.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.models.GameHistory

@Composable
fun HistoryScreen() {

    val historyList = listOf(
        GameHistory(1, "06/03/2026", 120, "Victoire"),
        GameHistory(2, "05/03/2026", 80, "Défaite"),
        GameHistory(3, "04/03/2026", 150, "Victoire"),
        GameHistory(4, "03/03/2026", 60, "Défaite")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Historique des parties",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(historyList) { game ->
                HistoryItem(game)
            }
        }
    }
}



@Composable
fun HistoryItem(game: GameHistory) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {

                Text(
                    text = game.date,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Score : ${game.score}",
                    fontSize = 14.sp
                )
            }

            Text(
                text = game.result,
                fontSize = 16.sp,
                color = if (game.result == "Victoire") Color(0xFF4CAF50) else Color.Red
            )
        }
    }
}