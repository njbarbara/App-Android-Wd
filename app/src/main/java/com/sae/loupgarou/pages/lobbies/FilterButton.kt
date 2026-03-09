package com.sae.loupgarou.pages.lobbies

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R.color
import com.sae.loupgarou.fontAldrich

@Composable
fun FilterButton(text: String, filterValue: String, currentFilter: String, onClick: (String) -> Unit) {
    val isSelected = filterValue == currentFilter
    val bgColor = if (isSelected) colorResource(id = color.Cyan600).copy(alpha = 0.8f) else colorResource(id = color.Slate800).copy(alpha = 0.6f)
    val textColor = if (isSelected) Color.White else colorResource(id = color.Cyan400)

    Box(
        modifier = Modifier
            .clickable { onClick(filterValue) }
            .background(bgColor, RoundedCornerShape(4.dp))
            .border(
                1.dp,
                if (isSelected) Color.Transparent else colorResource(id = color.Cyan600).copy(alpha = 0.3f),
                RoundedCornerShape(4.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = textColor, fontFamily = fontAldrich, fontSize = 12.sp)
    }
}