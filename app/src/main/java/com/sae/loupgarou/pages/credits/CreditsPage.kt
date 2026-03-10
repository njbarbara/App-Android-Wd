package com.sae.loupgarou.pages.credits

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun CreditsPage(onReturn: () -> Unit){
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
        Retour(onReturn)
    }
}
