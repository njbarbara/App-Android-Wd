package com.sae.loupgarou.pages.home

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R
import com.sae.loupgarou.R.color
import com.sae.loupgarou.fontAldrich


@Composable
fun settingsButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .padding(start = 16.dp, top = 52.dp) // marge côté et top
            .size(48.dp)
            .clip(CircleShape)
            //.background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
            .background(Color.White.copy(alpha = 0.7f))

        .clickable(onClick = { onClick() }),
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
fun ProfileButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .padding(end = 16.dp, top = 52.dp) // même top que Settings
            .size(48.dp)
            .clip(CircleShape)
            //.background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
            .background(Color.White.copy(alpha = 0.7f))

        .clickable { onClick() },
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
fun StartButton(modifier: Modifier = Modifier, onClick: () -> Unit){
    OutlinedButton(
        onClick = { onClick() },
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
fun HistoryButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
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
                color = colorResource(id = color.light_blue),
                shape = RectangleShape
            )
            .background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
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
fun RegleButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
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
                color = colorResource(id = color.light_blue),
                shape = RectangleShape
            )
            .background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = "Règles",
            color = Color.White,
            style = androidx.compose.ui.text.TextStyle(
                fontFamily = fontAldrich,
                fontSize = 30.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
            )
        )
    }
}



@Composable
fun CreditButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
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
                color = colorResource(id = color.light_blue),
                shape = RectangleShape
            )
            .background(color = colorResource(id = color.deep_marine), shape = RectangleShape)
            .clickable { onClick() },
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = "Crédit",
            color = Color.White,
            style = androidx.compose.ui.text.TextStyle(
                fontFamily = fontAldrich,
                fontSize = 30.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
            )
        )
    }
}

@Composable
fun HomePage(onSettingsClick: () -> Unit,
             onProfileClick: () -> Unit,
             onPlayClick: () -> Unit,
             onHistoryClick: () -> Unit,
             onRulesClick: () -> Unit,
             onCreditsClick: () -> Unit
) {
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


            settingsButton(Modifier.align(Alignment.TopStart), onSettingsClick)
            ProfileButton(Modifier.align(Alignment.TopEnd), onProfileClick)
            StartButton(Modifier.align(Alignment.Center).offset(y = -220.dp), onPlayClick)
            HistoryButton(Modifier.align(Alignment.Center).offset(y = 0.dp), onHistoryClick)
            RegleButton(Modifier.align(Alignment.Center).offset(y = 90.dp), onRulesClick)
            CreditButton(Modifier.align(Alignment.Center).offset(y = 180.dp), onCreditsClick)
    }
}
