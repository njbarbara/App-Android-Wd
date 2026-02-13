package com.sae.loupgarou

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import com.sae.loupgarou.ui.theme.SAELoupGarouTheme
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.font
import com.sae.loupgarou.R.string

val fontAldrich = FontFamily(
    Font(font.aldrich_regular, FontWeight.Normal)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SAELoupGarouTheme {
                Credits()
            }
        }
    }
}


@Composable
fun Credits(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        .clip(CutCornerShape(20.dp))
        .border(1.dp, color = colorResource(id = color.light_blue))
        .background(color = colorResource(id = color.marine)),
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
            fontFamily = fontAldrich
        )
        Text(text = stringResource(string.members2),
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp),
            fontFamily = fontAldrich
        )
        Text(text = stringResource(string.members3),
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp),
            fontFamily = fontAldrich
        )
    }
}

@Composable
fun Retour(){
    Row(modifier = Modifier
        .clip(CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp))
        .background(color = colorResource(id = color.deep_blue), shape = RectangleShape)
        .border(1.dp, color = colorResource(id = color.light_blue))
        ){
        Text(text = stringResource(string.return_button),
            fontFamily = fontAldrich,
            modifier = Modifier.padding(20.dp).clickable(true, onClick = { /*TODO*/ }),
            color = colorResource(id = color.light_blue)
        )
    }
}