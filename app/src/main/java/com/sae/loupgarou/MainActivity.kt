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
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .clip(CutCornerShape(20.dp))
                    .border(1.dp, color = colorResource(id = color.light_blue))
                    .background(color = colorResource(id = color.marine)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Rules()
                    Roles()
                    Deroulement()
                    Text(text = "Choisissez bien et n'exécutez pas vos concitoyens. Bonne chance !",
                        color = colorResource(id = color.light_blue),
                        fontFamily = fontAldrich
                    )
                }
            }
        }
    }
}

@Composable
fun Rules(){
    Column(){
        Text(text= stringResource(string.rules),
            modifier = Modifier.padding(10.dp),
            color = Color.White,
            style = TextStyle(
                fontSize = 40.sp,
                shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
            ),
            fontFamily = fontAldrich
        )
        Text(text="Bienvenue dans Wolves of Democracy ! Vous incarnez un citoyen de notre magnifique démocratie, mais attention, les traîtres rôdent la nuit...",
            color = colorResource(id = color.light_blue),
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
        Text(text = "• Citoyen (Villageois) : Le jour, participez au débat et votez pour exécuter un joueur suspecté d'être un traître. Votre but est d'éliminer tous les traîtres.",
            color = colorResource(id = color.light_blue),
            fontFamily = fontAldrich
        )
        Text(text = "• Traître (Loup-Garou) : La nuit, avec vos complices, vous vous réveillez pour assassiner un citoyen. Le jour, vous vous faites passer pour un innocent. Votre but est que les traîtres deviennent plus nombreux que les citoyens.",
            color = colorResource(id = color.light_blue),
            fontFamily = fontAldrich
        )
    }
}

@Composable
fun Deroulement(){
    Text(text = "Déroulement : ",
        color = Color.White,
        fontFamily = fontAldrich
    )
    Text(text = "1. La Nuit : Les traîtres se concertent et choisissent une victime.",
        color = colorResource(id = color.light_blue),
        fontFamily = fontAldrich
    )
    Text(text = "2. Le Jour : Les citoyens découvrent la victime de la nuit. Un débat s'ouvre, suivi d'un vote pour exécuter un suspect.",
        color = colorResource(id = color.light_blue),
        fontFamily = fontAldrich
    )
    Text(text = "3. Fin de la partie : La partie se termine quand tous les traîtres sont éliminés (victoire des citoyens) ou quand les traîtres sont en supériorité numérique (victoire des traîtres).",
        color = colorResource(id = color.light_blue),
        fontFamily = fontAldrich
    )
}
