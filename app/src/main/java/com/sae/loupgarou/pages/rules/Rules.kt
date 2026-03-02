package com.sae.loupgarou.pages.rules

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.string

@Composable
fun Rules(){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(text= stringResource(string.rules),
            color = Color.White,
            style = TextStyle(
                fontSize = 40.sp,
                shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
            ),
            fontFamily = fontAldrich,

            )
        Text(text= stringResource(string.welcome),
            color = colorResource(id = color.light_blue),
            fontFamily = fontAldrich,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(0.dp, 25.dp, 0.dp, 0.dp)
        )
    }
}
