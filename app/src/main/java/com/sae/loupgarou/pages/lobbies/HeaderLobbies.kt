package com.sae.loupgarou.pages.lobbies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R
import com.sae.loupgarou.R.color
import com.sae.loupgarou.fontAldrich

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
                        colors = listOf(Color.Transparent, colorResource(id = color.Cyan400), Color.Transparent)
                    )
                )
        )
        Text(
            text = stringResource(id = R.string.lobbies_subtitle),
            color = colorResource(id = color.Cyan400).copy(alpha = 0.8f),
            fontSize = 14.sp,
            fontFamily = fontAldrich,
            modifier = Modifier.padding(bottom = 24.dp)
        )
    }
}