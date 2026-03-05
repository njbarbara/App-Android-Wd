package com.sae.loupgarou.pages.creation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.sae.loupgarou.R
import com.sae.loupgarou.R.string
import com.sae.loupgarou.fontAldrich

@Composable
fun Duree(){
    var sliderPosition by remember { mutableFloatStateOf(45f) }
    Column {
        Text(
            text = stringResource(string.duree),
            style = TextStyle(
                fontFamily = fontAldrich,
                color = colorResource(id = R.color.light_blue)
            )
        )
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            steps=45,
            valueRange = 45f..90f,
            colors = SliderDefaults.colors(
                thumbColor = colorResource(id = R.color.light_blue),
                activeTrackColor = colorResource(id = R.color.light_blue),
                inactiveTrackColor = colorResource(id = R.color.deep_marine)
            )
        )
        Text(
            text = sliderPosition.toInt().toString(),
            style = TextStyle(
                fontFamily = fontAldrich,
                color = colorResource(id = R.color.light_blue)
            )
        )
    }
}
