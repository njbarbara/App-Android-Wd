package com.sae.loupgarou.pages.credits

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.font
import com.sae.loupgarou.R.string

val fontAldrich = FontFamily(
    Font(font.aldrich_regular, FontWeight.Normal)
)


@Composable
fun Credits(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = color.marine))
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text= stringResource(string.credits),
            modifier = Modifier.padding(10.dp),
            color = Color.White,
            style = TextStyle(
                fontSize = 60.sp,
                shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
            ),
            fontFamily = fontAldrich
        )
        Context()
        Equipe()
        Retour()
    }
}


@Composable
fun Context(){
    Column(modifier = Modifier
        .padding(10.dp)
        .clip(CutCornerShape(10.dp))
        .background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
        .border(1.dp, color = colorResource(id = color.light_blue))
    ){
        Text(text=stringResource(string.context1),
            color = Color.White,
            modifier = Modifier.padding(5.dp),
            fontFamily = fontAldrich,
            style = TextStyle(
                shadow = Shadow(color = Color.White, blurRadius = 20f)
            )
        )
        Text(text=stringResource(string.context2),
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp),
            fontFamily = fontAldrich
        )
        Text(text=stringResource(string.context3),
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp),
            fontFamily = fontAldrich
        )
        Text(text=stringResource(string.context4),
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp),
            fontFamily = fontAldrich
        )
    }
}


@Composable
fun Equipe(){
    Column(modifier = Modifier
        .padding(10.dp)
        .clip(CutCornerShape(10.dp))
        .background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
        .border(1.dp, color = colorResource(id = color.light_blue))
        .fillMaxWidth()

    ){
        Text(text=stringResource(string.dev_team),
            color = Color.White,
            modifier = Modifier.padding(5.dp),
            fontFamily = fontAldrich,
            style = TextStyle(
                shadow = Shadow(color = Color.White, blurRadius = 20f)
            )
        )
        Text(text = stringResource(string.members1),
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp),
            fontFamily = fontAldrich,
            textAlign = TextAlign.Justify
        )
        Text(text = stringResource(string.members2),
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp),
            fontFamily = fontAldrich,
            textAlign = TextAlign.Justify
        )
        Text(text = stringResource(string.members3),
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp),
            fontFamily = fontAldrich,
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun Retour(){
    OutlinedButton(
        onClick = { /* TODO */ },
        shape = CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = color.deep_blue), shape=CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp)),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            width = 2.dp,
            brush = androidx.compose.ui.graphics.SolidColor(colorResource(id = color.light_blue))
        )
    ) {
        Text(stringResource(string.return_button),
            fontFamily = fontAldrich,
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(vertical = 10.dp),
            fontSize = 20.sp)
    }
}
