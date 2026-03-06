package com.sae.loupgarou.pages.authentification.inscription


import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sae.loupgarou.R
import com.sae.loupgarou.viewmodels.LoginViewModel
import com.sae.loupgarou.viewmodels.RegisterViewModel

val fontAldrich = FontFamily(
    Font(R.font.aldrich_regular, FontWeight.Normal)
)

@Composable
fun InscriptionPage(viewModel: RegisterViewModel = viewModel()) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val isEmailError = email.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isPasswordError = password.isNotEmpty() && password.length < 6
    val doPasswordsMatch = confirmPassword.isNotEmpty() && password != confirmPassword

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.deep_marine))
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.earth),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
        )

        Column(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .border(
                    width = 2.dp,
                    color = colorResource(id = R.color.light_blue),
                    shape = CutCornerShape(10.dp)
                )
                .background(
                    color = colorResource(R.color.deep_marine),
                    shape = CutCornerShape(10.dp)
                )
                .padding(vertical = 40.dp, horizontal = 25.dp),

            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.inscription),
                fontFamily = fontAldrich,
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 20.dp)
            )


            AuthTextField(
                label = stringResource(id = R.string.email_label),
                value = email,
                onValueChange = { email = it },
                isError = isEmailError,
                errorMessage = stringResource(id = R.string.email_invalid)
            )


            AuthTextField(
                label = stringResource(id = R.string.username_label),
                value = username,
                onValueChange = { username = it }
            )


            AuthTextField(
                label = stringResource(id = R.string.password_label),
                value = password,
                onValueChange = { password = it },
                isError = isPasswordError,
                errorMessage = stringResource(id = R.string.password_too_short),
                isPassword = true
            )


            AuthTextField(
                label = stringResource(id = R.string.confirm_password_label),
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                isError = doPasswordsMatch,
                errorMessage = stringResource(id = R.string.passwords_dont_match),
                isPassword = true
            )


            Button(
                onClick = { viewModel.register(username, email, password) },
                enabled = !viewModel.isLoading,
                shape = CutCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.light_blue))
            ) {
                if (viewModel.isLoading) {
                    CircularProgressIndicator(color = Color.White)
                } else {
                    Text(
                        text = stringResource(id = R.string.btn_register),
                        fontFamily = fontAldrich,
                        color = colorResource(id = R.color.deep_blue),
                        modifier = Modifier.padding(vertical = 10.dp)
                    )
                }
            }
            viewModel.registerResult?.let { result ->
                Text(text = result, color = Color.Red)
            }

            OutlinedButton(
                onClick = {
                    email = ""
                    password = ""
                    confirmPassword = ""
                    username = ""
                },
                shape = CutCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth(),
                border = ButtonDefaults.outlinedButtonBorder.copy(
                    width = 2.dp,
                    brush = SolidColor(colorResource(id = R.color.light_blue))
                )
            ) {
                Text(
                    text = stringResource(id = R.string.btn_reset),
                    fontFamily = fontAldrich,
                    color = colorResource(id = R.color.light_blue),
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }

            Row(modifier = Modifier.padding(top = 20.dp)) {
                Text(
                    text = stringResource(id = R.string.already_registered),
                    color = Color.White,
                    fontFamily = fontAldrich
                )
                Text(
                    text = stringResource(id = R.string.login_link),
                    color = colorResource(id = R.color.light_blue),
                    fontFamily = fontAldrich,
                    modifier = Modifier.clickable { /* TODO */ }
                )
            }
        }
    }
}

