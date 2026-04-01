package com.sae.loupgarou.pages.historique

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sae.loupgarou.R
import com.sae.loupgarou.R.color
import com.sae.loupgarou.pages.Retour
import com.sae.loupgarou.viewmodels.HistoriqueViewModel

@Composable
fun HistoriquePage(viewModel: HistoriqueViewModel = viewModel(), onReturn: () -> Unit) {
    LaunchedEffect(Unit) {
        viewModel.fetchGames()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.earth),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .border(
                    width = 2.dp,
                    color = colorResource(color.light_blue),
                    shape = CutCornerShape(20.dp)
                )
                .background(
                    color = colorResource(color.deep_marine),
                    shape = CutCornerShape(20.dp)
                )
                .padding(vertical = 40.dp, horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            if (viewModel.isLoading) {
                CircularProgressIndicator(color = Color.White)
            } else if (viewModel.errorMessage != null) {
                Text(text = viewModel.errorMessage!!, color = Color.Red)
            } else {
                RecentGames(games = viewModel.previousGames)
            }
            Retour(onReturn)
        }
    }
}
