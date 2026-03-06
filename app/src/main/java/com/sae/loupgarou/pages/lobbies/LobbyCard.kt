package com.sae.loupgarou.pages.lobbies

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R.color
import com.sae.loupgarou.model.Lobby

@Composable
fun LobbyCard(lobby: Lobby) {
    val statusColor = when {
        lobby.isEnded || lobby.phase == "ended" -> Color.Gray
        lobby.phase == "lobby" -> colorResource(id = color.Cyan400)
        lobby.phase == "playing" -> Color(0xFFF59E0B)
        else -> Color.Gray
    }

    Box(
        modifier = Modifier
            .background(colorResource(id = color.Slate900).copy(alpha = 0.9f), CutCornerShape(topStart = 16.dp, bottomEnd = 16.dp))
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