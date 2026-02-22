package com.sae.loupgarou


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.ui.theme.SAELoupGarouTheme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.string
import com.sae.loupgarou.R.font

val fontAldrich = FontFamily(
    Font(font.aldrich_regular, FontWeight.Normal)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SAELoupGarouTheme {
                Column(){
                    Rules()
                    Roles()
                    Deroulement()
                }
            }
        }
    }
}

@Composable
fun Rules(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        .clip(CutCornerShape(20.dp))
        .border(1.dp, color = colorResource(id = color.light_blue))
        .background(color = colorResource(id = color.marine)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text= stringResource(string.rules),
            modifier = Modifier.padding(10.dp),
            color = Color.White,
            style = TextStyle(
                fontSize = 40.sp,
                shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
            ),
            fontFamily = fontAldrich
        )
    }
}

@Composable
fun Roles(){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Les Rôles : ",
            color = Color.White,
            fontFamily = fontAldrich
        )
        Text(text = "• Citoyen (Villageois) : ")
        Text(text = "• Traître (Loup-Garou) : ")
    }
}

@Composable
fun Deroulement(){

}