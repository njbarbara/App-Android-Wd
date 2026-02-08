package com.sae.loupgarou

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColor
import com.sae.loupgarou.ui.theme.SAELoupGarouTheme
import com.sae.loupgarou.R.color.marine
import com.sae.loupgarou.R.color.deep_marine
import com.sae.loupgarou.R.color.light_blue


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
        .padding(10.dp)
        .clip(RoundedCornerShape(5.dp))
        .background(color = colorResource(id = marine))
        .border(1.dp, color = colorResource(id = light_blue))
    ){
        Text("")
        Text(color = Color.White, text="Crédits")
        Context()
        Equipe()
        //Retour()
    }
}


@Composable
fun Context(){
    Column(modifier = Modifier
        .padding(10.dp)
        .clip(RoundedCornerShape(5.dp))
        .background(color = colorResource(id = deep_marine), shape = RectangleShape)
        .border(1.dp, color = colorResource(id = light_blue))
    ){
        Text(color = Color.White, text="Contexte du Projet")
        Text(color = colorResource(id = light_blue), text="Ce projet a été réalisé dans le cadre de la SAE 2A du BUT informatique.")
        Text(color = colorResource(id = light_blue), text="Nous somme une équipe de 6 étudiants : 5 en formation initiale et un alternant")
        Text(color = colorResource(id = light_blue), text="Ce projet est une reconstitution du jeu de société\"les Loups Garous de Thiercelieu\"")
    }
}


@Composable
fun Equipe(){
    Column(modifier = Modifier
        .padding(10.dp)
        .clip(RoundedCornerShape(5.dp))
        .background(color = colorResource(id = deep_marine), shape = RectangleShape)
        .border(1.dp, color = colorResource(id = light_blue))

        ){
        Text(color = Color.White, text="Équipe de Developpement")
        Row(){
            Text(color = colorResource(id = light_blue), text="Anis YOUNES    Cyril BARRALLON    Esteban JACQUES")
        }
        Row(){
            Text(color = colorResource(id = light_blue), text="Najib BARBARA  Neil BONNETOT      Robin Werner")
        }
    }
}

@Composable
fun Retour(){
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Retour à l'acceuil")
    }
}