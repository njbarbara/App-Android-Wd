package com.sae.loupgarou.pages.lobbies

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.sae.loupgarou.R
import com.sae.loupgarou.R.color

@Composable
fun BackgroundLobbies() {
    // Le fond (Image + Filtre sombre)
    Image(
        painter = painterResource(id = R.drawable.earth), // Remplace par ton image
        contentDescription = stringResource(id = R.string.lobbies_background_desc),
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = color.Slate900).copy(alpha = 0.85f))
    )
}