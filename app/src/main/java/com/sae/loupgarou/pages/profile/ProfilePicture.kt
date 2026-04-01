package com.sae.loupgarou.pages.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sae.loupgarou.R

@Composable
fun ProfilePicture(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "Profile",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(120.dp)
            .clip(CircleShape)
            .border(3.dp, Color.White, CircleShape)
            .border(6.dp, Color(0xFF22D3EE).copy(alpha = 0.5f), CircleShape) // Cyan border effect
    )
}