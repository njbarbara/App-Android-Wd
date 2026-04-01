package com.sae.loupgarou.pages.historique

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R
import com.sae.loupgarou.R.string

@Composable
fun GameTemplate(
    gameDate: String,
    gameResult: String?,
    rolePlayed: String,
    nightsCount: Int
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = colorResource(R.color.marine).copy(alpha = 0.5f),
                shape = CutCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = colorResource(R.color.light_blue),
                shape = CutCornerShape(12.dp)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = gameDate,
                color = colorResource(R.color.light_blue),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            
            val resultText = gameResult ?: "EN COURS"
            val resultColor = when (resultText.lowercase()) {
                "victoire", "win" -> Color.Green
                "défaite", "loss" -> colorResource(R.color.light_red)
                else -> Color.White
            }

            Text(
                text = resultText.uppercase(),
                color = resultColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = rolePlayed,
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "$nightsCount ${stringResource(string.nuit)}s",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 14.sp
            )
        }
    }
}
