package com.sae.loupgarou.pages.home

import android.R.attr.font
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.string


/*
val insets = rootWindowInsets
val topRight = insets.getRoundedCorner(RoundedCorner.POSITION_TOP_RIGHT) ?: return*/

val fontAldrich = FontFamily(
    Font(R.font.aldrich_regular, FontWeight.Normal)
)


@Composable
fun settingsButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(start = 16.dp, top = 52.dp) // marge côté et top
            .size(48.dp)
            .clip(CircleShape)
            //.background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
            .background(Color.White.copy(alpha = 0.7f))

        /*.clickable {
            val intent = Intent(context, SettingsActivity::class.java)
            context.startActivity(intent)
        }*/,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.metal_gear2),
            contentDescription = "Settings",
            modifier = Modifier.fillMaxSize(0.6f)
        )
    }
}

@Composable
fun ProfileButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(end = 16.dp, top = 52.dp) // même top que Settings
            .size(48.dp)
            .clip(CircleShape)
            //.background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
            .background(Color.White.copy(alpha = 0.7f))

            //.background(Color.White.copy(alpha = 0.7f))
        /*.clickable {
            val intent = Intent(context, ProfileActivity::class.java)
            context.startActivity(intent)
        }*/,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Composable
fun StartButton(modifier: Modifier = Modifier,
                onClick: () -> Unit){
    OutlinedButton(
        onClick = { /* TODO */ },
        shape = CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp),
        modifier = modifier
            .size(350.dp,80.dp)
            .fillMaxWidth()
            .background(color = colorResource(id = color.deep_blue), shape=CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp)),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            width = 2.dp,
            brush = SolidColor(colorResource(id = color.light_blue))
        )
    ) {
        Text(
            text = "Jouer",
            color = Color.White,
            style = androidx.compose.ui.text.TextStyle(
                fontFamily = fontAldrich,
                fontSize = 40.sp, // 👈 maintenant reconnu
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
            )
        )
    }
}

@Composable
fun StartButtonWolf(modifier: Modifier = Modifier,
                onClick: () -> Unit){
    OutlinedButton(
        onClick = { /* TODO */ },
        shape = CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp),
        modifier = modifier
            .size(350.dp,80.dp)
            .fillMaxWidth()
            .background(color = colorResource(id = color.deep_blue), shape=CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp)),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            width = 2.dp,
            brush = SolidColor(colorResource(id = color.light_red2))
        )
    ) {
        Text(
            text = "Jouer",
            color = Color.White,
            style = androidx.compose.ui.text.TextStyle(
                fontFamily = fontAldrich,
                fontSize = 40.sp, // 👈 maintenant reconnu
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                shadow = Shadow(color = colorResource(id = color.light_red), blurRadius = 60f)
            )
        )
    }
}

/*.background(
                brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                    colors = listOf(Color(0xFFFF5252), Color(0xFFD32F2F)),
                    shape=CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp))
                ),

            )*/


@Composable
fun HistoryButton(modifier: Modifier = Modifier,
                onClick: () -> Unit) {
    Box(
        modifier = modifier
            .size(240.dp,60.dp) // taille du bouton
            .clip(RectangleShape) // rond
            .background(
                brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                    colors = listOf(Color(0xFFFF5252), Color(0xFFD32F2F)),

                )
            )
            .border(
                width = 2.dp,
                /*brush = Brush.horizontalGradient(
                    listOf(Color.Red, Color.DarkGray)
                ),*/
                color = colorResource(id = color.light_blue),
                shape = RectangleShape
            )
            .background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
            //.shadow(8.dp, CircleShape) // ombre
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Historique",
            color = Color.White,
            style = androidx.compose.ui.text.TextStyle(
                fontFamily = fontAldrich,
                fontSize = 30.sp, // 👈 maintenant reconnu
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
            )
        )
    }
}




@Composable
fun HistoryButtonWolf(modifier: Modifier = Modifier,
                  onClick: () -> Unit) {
    Box(
        modifier = modifier
            .size(240.dp,60.dp) // taille du bouton
            .clip(RectangleShape) // rond
            .background(
                brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                    colors = listOf(Color(0xFFFF5252), Color(0xFFD32F2F))
                )
            )
            .border(
                width = 2.dp,
                /*brush = Brush.horizontalGradient(
                    listOf(Color.Red, Color.DarkGray)
                ),*/
                color = colorResource(id = color.light_red2),
                shape = RectangleShape
            )
            .background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
            //.shadow(8.dp, CircleShape) // ombre
            .clickable { onClick() },
        contentAlignment = Alignment.Center,

    ) {
        Text(
            text = "Historique",
            color = Color.White,
            style = androidx.compose.ui.text.TextStyle(
                fontFamily = fontAldrich,
                fontSize = 30.sp, // 👈 maintenant reconnu
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                shadow = Shadow(color = colorResource(id = color.light_red), blurRadius = 60f)
            )
        )
    }
}



@Composable
fun RegleButton(modifier: Modifier = Modifier,
                 onClick: () -> Unit) {
    Box(
        modifier = modifier
            .size(240.dp,60.dp) // taille du bouton
            .clip(RectangleShape) // rond
            .background(
                brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                    colors = listOf(Color(0xFFFF5252), Color(0xFFD32F2F))
                )
            )
            .border(
                width = 2.dp,
                /*brush = Brush.horizontalGradient(
                    listOf(Color.Red, Color.DarkGray)
                ),*/
                color = colorResource(id = color.light_blue),
                shape = RectangleShape
            )
            .background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
            //.shadow(8.dp, CircleShape) // ombre
            .clickable { onClick() },
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = "Règles",
            color = Color.White,
            style = androidx.compose.ui.text.TextStyle(
                fontFamily = fontAldrich,
                fontSize = 30.sp, // 👈 maintenant reconnu
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
            )
        )
    }
}



@Composable
fun CreditButton(modifier: Modifier = Modifier,
                      onClick: () -> Unit) {
    Box(
        modifier = modifier
            .size(240.dp,60.dp) // taille du bouton
            .clip(RectangleShape) // rond
            .background(
                brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                    colors = listOf(Color(0xFFFF5252), Color(0xFFD32F2F))
                )
            )
            .border(
                width = 2.dp,
                /*brush = Brush.horizontalGradient(
                    listOf(Color.Red, Color.DarkGray)
                ),*/
                color = colorResource(id = color.light_blue),
                shape = RectangleShape
            )
            .background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
            //.shadow(8.dp, CircleShape) // ombre
            .clickable { onClick() },
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = "Crédit",
            color = Color.White,
            style = androidx.compose.ui.text.TextStyle(
                fontFamily = fontAldrich,
                fontSize = 30.sp, // 👈 maintenant reconnu
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
            )
        )
    }
}

@Composable
fun HomePage() {
    val randomValue = (0..1).random()
    Box(modifier = Modifier.fillMaxSize()) {

        // Image de fond
        Image(
            painter = painterResource(id = R.drawable.earth),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().blur(3.dp)
                .align(Alignment.Center)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
               // .background(Color.DarkGray.copy(alpha = 0.7f))//(alpha = 0.4f)) // 👈 intensité
        )


            settingsButton(Modifier.align(Alignment.TopStart))
            ProfileButton(Modifier.align(Alignment.TopEnd))
            StartButton(Modifier.align(Alignment.Center).offset(y = -220.dp)) {}
            HistoryButton(Modifier.align(Alignment.Center).offset(y = 0.dp)) {}
            RegleButton(Modifier.align(Alignment.Center).offset(y = 90.dp)) {}
            CreditButton(Modifier.align(Alignment.Center).offset(y = 180.dp)) {}
        /*
            settingsButton(Modifier.align(Alignment.TopStart))
            ProfileButton(Modifier.align(Alignment.TopEnd))
            StartButtonWolf(Modifier.align(Alignment.Center).offset(y = -220.dp)) {}
            HistoryButtonWolf(Modifier.align(Alignment.Center).offset(y = 0.dp)) {}
            RegleButton(Modifier.align(Alignment.Center).offset(y = 90.dp)) {}
            CreditButton(Modifier.align(Alignment.Center).offset(y = 180.dp)) {}*/

    }
}

/*
@Composable
fun MyBottomBar() {
    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = selectedItem == 0,
            onClick = { selectedItem = 0 }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = selectedItem == 1,
            onClick = { selectedItem = 1 }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
            label = { Text("Settings") },
            selected = selectedItem == 2,
            onClick = { selectedItem = 2 }
        )
    }
}*/