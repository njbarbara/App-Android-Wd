package com.sae.loupgarou.pages.creation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.string
import com.sae.loupgarou.fontAldrich
import com.sae.loupgarou.pages.Retour


@Composable
fun Creation(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = color.marine))
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text= stringResource(string.new_game),
            modifier = Modifier.padding(10.dp),
            color = Color.White,
            style = TextStyle(
                fontSize = 40.sp,
                shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
            ),
            fontFamily = fontAldrich
        )
        NbPlayers()
        CreateButton()
        Retour()
    }
}

@Composable
fun NbPlayers(){
    var sliderPosition by remember { mutableFloatStateOf(3f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            steps=12,
            valueRange = 3f..16f
        )
        Text(text = sliderPosition.toString())
    }
}


@Composable
fun CreateButton(){
    OutlinedButton(
        onClick = { /* TODO */ },
        shape = CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom=20.dp)
            .background(
                color = colorResource(id = color.deep_blue),
                shape=CutCornerShape(topStart=10.dp, bottomEnd = 10.dp)
            ),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            width = 2.dp,
            brush = androidx.compose.ui.graphics.SolidColor(colorResource(id = color.light_blue))
        )
    ) {
        Text(stringResource(string.create_game),
            fontFamily = fontAldrich,
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(vertical = 10.dp),
            fontSize = 20.sp)
    }
}