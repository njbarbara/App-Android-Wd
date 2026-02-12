package com.sae.loupgarou

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import com.sae.loupgarou.ui.theme.SAELoupGarouTheme
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.font

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
        Text(text="CRÉDITS",
            modifier = Modifier.padding(10.dp),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                fontSize = 60.sp,
                shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
            )
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
        Text(text="Contexte du Projet",
            color = Color.White,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text="Ce projet a été réalisé dans le cadre de la SAE 2A du BUT informatique.",
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp)
        )
        Text(text="Nous somme une équipe de 6 étudiants : 5 en formation initiale et un alternant",
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp)
        )
        Text(text="Ce projet est une reconstitution du jeu de société\"les Loups Garous de Thiercelieu\"",
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp)
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

        ){
        Text(text="Équipe de Developpement",
            color = Color.White,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Bold
        )
        Text(text = "Anis YOUNES    Cyril BARRALLON    Esteban JACQUES",
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp),
            fontSize = 13.sp
        )
        Text(text = "Najib BARBARA  Neil BONNETOT      Robin Werner",
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(5.dp),
            fontSize = 13.sp
        )
    }
}

@Composable
fun Retour(){
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Retour à l'acceuil")
    }
}