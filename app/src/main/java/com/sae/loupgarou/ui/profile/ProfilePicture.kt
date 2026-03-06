package com.sae.loupgarou.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.sae.loupgarou.R

@Composable

fun profilePicture(){
    Image(
        painter = painterResource(id = ),
        contentDescription = "Profile",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}