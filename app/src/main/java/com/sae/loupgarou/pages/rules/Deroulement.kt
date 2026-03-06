package com.sae.loupgarou.pages.rules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.string
import com.sae.loupgarou.fontAldrich

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
