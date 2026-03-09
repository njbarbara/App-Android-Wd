package com.sae.loupgarou.pages.lobbies

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.sae.loupgarou.R.color
import com.sae.loupgarou.fontAldrich

@Composable
fun ActionButtons(onCreateLobby: () -> Unit, onRefresh: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(bottom = 24.dp)
    ) {
        Button(
            onClick = {
                Log.i("Lobby", "création d'un lobby")
                onCreateLobby()},
            shape = CutCornerShape(topStart = 12.dp, bottomEnd = 12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = color.Cyan600))
        ) {
            Icon(Icons.Default.Add, contentDescription = "Créer", tint = Color.White)
            Spacer(Modifier.width(8.dp))
            Text("Créer un Lobby", fontFamily = fontAldrich, color = Color.White)
        }

        OutlinedButton(
            onClick = onRefresh,
            shape = CutCornerShape(topStart = 12.dp, bottomEnd = 12.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = colorResource(id = color.Slate800).copy(alpha = 0.8f)),
            border = BorderStroke(1.dp, colorResource(id = color.Cyan600).copy(alpha = 0.5f))
        ) {
            Icon(Icons.Default.Refresh, contentDescription = "Actualiser", tint = colorResource(id = color.Cyan400))
            Spacer(Modifier.width(8.dp))
            Text("Actualiser", fontFamily = fontAldrich, color = colorResource(id = color.Cyan400))
        }
    }
}