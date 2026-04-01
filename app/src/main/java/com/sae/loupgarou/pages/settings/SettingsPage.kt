package com.sae.loupgarou.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R
import com.sae.loupgarou.R.color
import com.sae.loupgarou.pages.settings.VolumeSlider
import com.sae.loupgarou.fontAldrich
import com.sae.loupgarou.pages.Retour


@Composable
fun SettingsPage(onReturn: () -> Unit) {
    var generalVolume by remember { mutableFloatStateOf(0.7f) }
    var soundVolume by remember { mutableFloatStateOf(0.5f) }
    var musicVolume by remember { mutableFloatStateOf(0.6f) }
    var selectedLanguage by remember { mutableStateOf("FR") }

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
            Text(text= stringResource(R.string.settings),
                modifier = Modifier.padding(10.dp),
                color = Color.White,
                style = TextStyle(
                    fontSize = 40.sp,
                    shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
                ),
                fontFamily = fontAldrich
            )
            // Buttons Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Mode button
                Box(
                    modifier = Modifier
                        .weight(1.5f)
                        .border(1.dp, colorResource(R.color.light_blue), CutCornerShape(8.dp))
                        .background(colorResource(R.color.deep_blue), CutCornerShape(8.dp))
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.mode_clair_sombre),
                        color = colorResource(color.light_blue),
                        fontFamily = fontAldrich,
                        fontSize = 12.sp
                    )
                }

                // FR button
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .border(1.dp, colorResource(color.light_blue), CutCornerShape(topStart = 8.dp, bottomEnd = 8.dp))
                        .background(
                            if (selectedLanguage == "FR") colorResource(color.light_blue) else colorResource(color.deep_blue),
                            CutCornerShape(topStart = 8.dp, bottomEnd = 8.dp)
                        )
                        .clickable { selectedLanguage = "FR" }
                        .padding(vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "FR",
                        color = if (selectedLanguage == "FR") colorResource(color.deep_blue) else colorResource(color.light_blue),
                        fontFamily = fontAldrich,
                        fontWeight = FontWeight.Bold
                    )
                }


                Box(
                    modifier = Modifier
                        .weight(1f)
                        .border(1.dp, colorResource(color.light_blue), CutCornerShape(topStart = 8.dp, bottomEnd = 8.dp))
                        .background(
                            if (selectedLanguage == "EN") colorResource(color.light_blue) else colorResource(color.deep_blue),
                            CutCornerShape(topStart = 8.dp, bottomEnd = 8.dp)
                        )
                        .clickable { selectedLanguage = "EN" }
                        .padding(vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "EN",
                        color = if (selectedLanguage == "EN") colorResource(color.deep_blue) else colorResource(color.light_blue),
                        fontFamily = fontAldrich,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                VolumeSlider(label = stringResource(R.string.volume_general), value = generalVolume, onValueChange = { generalVolume = it })
                VolumeSlider(label = stringResource(R.string.volume_sons), value = soundVolume, onValueChange = { soundVolume = it })
                VolumeSlider(label = stringResource(R.string.volume_musique), value = musicVolume, onValueChange = { musicVolume = it })
            }
            Retour(onReturn)
        }
    }
}


