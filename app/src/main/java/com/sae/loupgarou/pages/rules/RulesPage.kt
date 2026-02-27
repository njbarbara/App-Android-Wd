package com.sae.loupgarou.pages.rules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.string
import com.sae.loupgarou.fontAldrich
import com.sae.loupgarou.pages.Retour



@Composable
fun RulePage(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = color.marine))
        .padding(20.dp, 50.dp)
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Rules()
        Roles()
        Deroulement()
        Text(text = stringResource(string.chose_right),
            color = colorResource(id = color.light_blue),
            fontFamily = fontAldrich
        )
        Retour()
    }
}

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

@Composable
fun Roles(){
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
    ){
        Text(text = stringResource(string.roles ),
            color = Color.White,
            fontFamily = fontAldrich,
            fontSize = 40.sp,
            textAlign = TextAlign.Justify
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = color.light_blue),
                        fontFamily = fontAldrich,
                        fontSize = 20.sp
                    )
                )
                {
                    append(stringResource(string.citoyen))
                }
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = color.light_blue),
                        fontFamily = fontAldrich
                    )
                )
                {
                    append(stringResource(string.citoyen_explain))
                }
            },
            textAlign = TextAlign.Justify
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = color.red),
                        fontFamily = fontAldrich,
                        fontSize = 20.sp
                    )
                )
                {
                    append(stringResource(string.wolf))
                }
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = color.light_blue),
                        fontFamily = fontAldrich
                    )
                )
                {
                    append(stringResource(string.wolf_explain))
                }
            },
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun Deroulement(){
    Column(
        modifier = Modifier.padding(10.dp)
    ){
        Text(text = stringResource(string.deroulement),
            color = Color.White,
            fontFamily = fontAldrich,
            fontSize = 40.sp,
            textAlign = TextAlign.Justify
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = color.red),
                        fontFamily = fontAldrich,
                        fontSize = 20.sp
                    )
                )
                {
                    append(stringResource(string.night))
                }
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = color.light_blue),
                        fontFamily = fontAldrich
                    )
                )
                {
                    append(stringResource(string.night_explain))
                }
            },
            textAlign = TextAlign.Justify
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = color.red),
                        fontFamily = fontAldrich,
                        fontSize = 20.sp
                    )
                )
                {
                    append(stringResource(string.day))
                }
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = color.light_blue),
                        fontFamily = fontAldrich
                    )
                )
                {
                    append(stringResource(string.day_explain))
                }
            },
            textAlign = TextAlign.Justify
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = color.red),
                        fontFamily = fontAldrich,
                        fontSize = 20.sp
                    )
                )
                {
                    append(stringResource(string.end))
                }
                withStyle(
                    style = SpanStyle(
                        color = colorResource(id = color.light_blue),
                        fontFamily = fontAldrich
                    )
                )
                {
                    append(stringResource(string.end_explain))
                }
            },
            textAlign = TextAlign.Justify
        )
    }
}