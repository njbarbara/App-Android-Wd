package com.sae.loupgarou.pages.GameSelection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.string
import com.sae.loupgarou.fontAldrich
import com.sae.loupgarou.pages.Retour
import com.sae.loupgarou.pages.credits.Context
import com.sae.loupgarou.pages.credits.Equipe
import com.sae.loupgarou.pages.home.CreditButton
import com.sae.loupgarou.pages.home.HistoryButton
import com.sae.loupgarou.pages.home.ProfileButton
import com.sae.loupgarou.pages.home.RegleButton
import com.sae.loupgarou.pages.home.SettingsButton
import com.sae.loupgarou.pages.home.StartButton


@Composable
fun GameSelectionPage(onCreateButtonClick: () -> Unit = {},
                      onJoinButtonClick: () -> Unit = {},
                      onReturn: () -> Unit = {}) {
    Box(modifier = Modifier.fillMaxSize()) {

        // Image de fond
        Image(
            painter = painterResource(id = R.drawable.earth),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().blur(3.dp)
                .align(Alignment.Center)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                //.background(color = colorResource(id = color.marine))
                .padding(10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "JOUER",
                modifier = Modifier.padding(10.dp),
                color = Color.White,
                style = TextStyle(
                    fontSize = 60.sp,
                    shadow = Shadow(color = colorResource(id = color.light_blue), blurRadius = 60f)
                ),
                fontFamily = fontAldrich
            )
            CreateButton(onCreateButtonClick)
            JoinButton(onJoinButtonClick)
            Retour(onReturn)
        }
    }
}

@Composable
fun CreateButton(onClick: () -> Unit) {
    OutlinedButton(
        onClick = { onClick() },
        shape = CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .background(color = colorResource(id = color.deep_blue), shape=CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp)),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            width = 2.dp,
            brush = androidx.compose.ui.graphics.SolidColor(colorResource(id = color.light_blue))
        )
    ) {
        Text("CREER UNE PARTIE",
            fontFamily = fontAldrich,
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(vertical = 10.dp),
            fontSize = 20.sp)
    }
}

@Composable
fun JoinButton(onClick: () -> Unit) {
    OutlinedButton(
        onClick = { onClick() },
        shape = CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 20.dp, 20.dp, 40.dp)
            .background(color = colorResource(id = color.deep_blue), shape=CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp)),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            width = 2.dp,
            brush = androidx.compose.ui.graphics.SolidColor(colorResource(id = color.light_blue))
        )
    ) {
        Text("REJOINDRE PARTIE",
            fontFamily = fontAldrich,
            color = colorResource(id = color.light_blue),
            modifier = Modifier.padding(vertical = 10.dp),
            fontSize = 20.sp)
    }
}

