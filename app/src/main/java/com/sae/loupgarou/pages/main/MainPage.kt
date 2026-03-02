package com.sae.loupgarou.pages.main


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R


val fontAldrich = FontFamily(
    Font(R.font.aldrich_regular, FontWeight.Normal)
)

@Composable
fun MainPage() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.mainpage_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
        )

        Column(
            modifier = Modifier

                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .border(
                    width = 2.dp,
                    color = colorResource(R.color.light_blue),
                    shape = CutCornerShape(20.dp)
                )
                .background(color = colorResource(R.color.deep_marine),
                            shape = CutCornerShape(20.dp))
                .padding(vertical = 50.dp, horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {

            Text(
                text = stringResource(id = R.string.main_title),
                fontFamily = fontAldrich,
                fontSize = 32.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 36.sp
            )

            Text(
                text = stringResource(id = R.string.main_subtitle),
                fontFamily = fontAldrich,
                fontSize = 14.sp,
                color = colorResource(R.color.light_blue),
                textAlign = TextAlign.Center
            )

            Button(
                onClick = { /* TODO */ },
                shape = CutCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.light_blue)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.btn_login),
                    fontFamily = fontAldrich,
                    fontSize = 18.sp,
                    color = colorResource(R.color.deep_blue),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }

            Text(
                text = stringResource(id = R.string.or),
                fontFamily = fontAldrich,
                fontSize = 16.sp,
                color = Color.White
            )

            OutlinedButton(
                onClick = { /* TODO */ },
                shape = CutCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.deep_blue)),
                modifier = Modifier.fillMaxWidth(),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 2.dp, brush = SolidColor(colorResource(id = R.color.light_blue)))
            )
            {
                Text(
                    text = stringResource(id = R.string.btn_register),
                    fontFamily = fontAldrich,
                    fontSize = 18.sp,
                    color = colorResource(R.color.light_blue),
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
        }
    }
}
