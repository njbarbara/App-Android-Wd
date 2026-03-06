package com.sae.loupgarou.pages.settings

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R
import com.sae.loupgarou.fontAldrich

@Composable
fun VolumeSlider(label: String, value: Float, onValueChange: (Float) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = colorResource(R.color.light_blue),
            fontFamily = fontAldrich,
            fontSize = 14.sp,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End
        )
        Slider(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.weight(2f).padding(horizontal = 10.dp),
            colors = SliderDefaults.colors(
                thumbColor = colorResource(R.color.white),
                activeTrackColor = colorResource(R.color.light_blue),
                inactiveTrackColor = colorResource(R.color.light_blue).copy(alpha = 0.3f)
            )
        )
    }
}