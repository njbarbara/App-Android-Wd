package com.sae.loupgarou.pages.authentification.connection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel // Import manquant

import com.sae.loupgarou.R
import com.sae.loupgarou.viewmodels.LoginViewModel


val AldrichFont = FontFamily(
    Font(R.font.aldrich_regular, FontWeight.Normal)
)

@Composable
fun ConnectionPage(viewModel: LoginViewModel = viewModel()) { // Ajout du paramètre ici
    var pseudo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
   
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.earth),
            contentDescription = stringResource(R.string.login_background_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .padding(24.dp)
                .border(
                    2.dp,
                    colorResource(R.color.light_blue),
                    CutCornerShape(topStart = 24.dp, bottomEnd = 24.dp)
                )
                .background(
                    colorResource(R.color.deep_marine).copy(alpha = 0.9f),
                    CutCornerShape(topStart = 24.dp, bottomEnd = 24.dp)
                )
                .padding(32.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.login_title),
                    fontFamily = AldrichFont,
                    color = Color.White,
                    fontSize = 32.sp,
                    letterSpacing = 2.sp
                )

                Text(
                    text = stringResource(R.string.login_subtitle),
                    fontFamily = AldrichFont,
                    color = colorResource(R.color.light_blue),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                OutlinedTextField(
                    value = pseudo,
                    onValueChange = { pseudo = it },
                    label = { Text(stringResource(R.string.pseudo), color = colorResource(R.color.light_blue)) },
                    textStyle = TextStyle(color = Color.White, fontFamily = AldrichFont),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(R.color.light_blue),
                        unfocusedBorderColor = colorResource(R.color.light_blue).copy(alpha = 0.5f),
                        cursorColor = colorResource(R.color.light_blue)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(stringResource(R.string.login_password_label), color = colorResource(R.color.light_blue)) },
                    visualTransformation = PasswordVisualTransformation(),
                    textStyle = TextStyle(color = Color.White, fontFamily = AldrichFont),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(R.color.light_blue),
                        unfocusedBorderColor = colorResource(R.color.light_blue).copy(alpha = 0.5f),
                        cursorColor = colorResource(R.color.light_blue)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { viewModel.login(pseudo, password) },
                    enabled = !viewModel.isLoading,
                    shape = CutCornerShape(topStart = 12.dp, bottomEnd = 12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.light_blue)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    if (viewModel.isLoading) {
                        CircularProgressIndicator(color = Color.White)
                    } else {
                        Text(
                            text = stringResource(R.string.login_button_text),
                            fontFamily = AldrichFont,
                            color = colorResource(R.color.deep_blue),
                            fontSize = 18.sp,
                            letterSpacing = 1.sp
                        )
                    }
                }
                viewModel.loginResult?.let { result ->
                    Text(text = result, color = Color.Red)
                }
            }
        }
    }
}