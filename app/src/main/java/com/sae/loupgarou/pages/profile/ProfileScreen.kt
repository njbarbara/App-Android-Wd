package com.sae.loupgarou.pages.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R
import com.sae.loupgarou.pages.Retour
import com.sae.loupgarou.fontAldrich
import com.sae.loupgarou.pages.lobbies.BackgroundLobbies
import com.sae.loupgarou.viewmodel.ProfileViewModel
import com.sae.loupgarou.pages.historique.GameTemplate

@Composable
fun ProfileScreen(
    onReturn: () -> Unit,
    viewModel: ProfileViewModel
) {
    val user by viewModel.user.collectAsState()
    val lastGame by viewModel.lastGame.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundLobbies()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .border(
                    width = 2.dp,
                    color = colorResource(id = R.color.Cyan400),
                    shape = CutCornerShape(40.dp)
                )
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = user?.username ?: "Chargement...",
                color = Color.White,
                fontSize = 32.sp,
                fontFamily = fontAldrich,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            ProfilePicture()

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Email : ${user?.email ?: "..."}",
                color = colorResource(id = R.color.Cyan400),
                fontSize = 14.sp,
                fontFamily = fontAldrich
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Recent Games Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(
                        color = colorResource(id = R.color.Slate900).copy(alpha = 0.8f),
                        shape = CutCornerShape(8.dp)
                    )
                    .border(1.dp, Color.White.copy(alpha = 0.2f), CutCornerShape(8.dp))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                if (isLoading) {
                    CircularProgressIndicator(color = colorResource(id = R.color.Cyan400))
                } else {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "PARTIE RÉCENTE",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = fontAldrich,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        
                        lastGame?.let { game ->
                            GameTemplate(
                                gameDate = game.gameDate,
                                gameResult = game.result,
                                rolePlayed = game.rolePlayed,
                                nightsCount = game.nightsCount
                            )
                        } ?: Text(
                            text = "Aucune partie récente.",
                            color = colorResource(id = R.color.Cyan400).copy(alpha = 0.7f),
                            fontSize = 14.sp,
                            fontFamily = fontAldrich,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "0 parties gagnées",
                color = Color.White,
                fontSize = 18.sp,
                fontFamily = fontAldrich
            )

            Spacer(modifier = Modifier.weight(1f))


            Retour(onReturn)
        }
    }
}


