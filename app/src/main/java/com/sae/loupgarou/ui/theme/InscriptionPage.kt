package com.sae.loupgarou.ui.theme


import android.util.Patterns
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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.sae.loupgarou.R.color
import com.sae.loupgarou.R.string
import com.sae.loupgarou.R.font

val fontAldrich = FontFamily(
    Font(font.aldrich_regular, FontWeight.Normal)
)


@Composable
fun InscriptionPage(){
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val isEmailError = email.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isPassWordError = password.isNotEmpty() && password.length < 6

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(color.deep_marine)),
        contentAlignment = Alignment.Center
    ){
        Column( modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 45.dp),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Nom") },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(4.dp, RoundedCornerShape(8.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colorResource(color.white),
                    unfocusedContainerColor = colorResource(color.white)
                )
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                isError = isEmailError,

                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                supportingText = {
                    if (isEmailError) {
                        Text("il faut un email valide")
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colorResource(color.white),
                    unfocusedContainerColor = colorResource(color.white),
                    errorContainerColor = colorResource(color.white)
                )
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Mot de passe") },
                singleLine = true,
                isError = isPassWordError,
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                supportingText = {
                    if (isPassWordError) {
                        Text("il faut au moins 6 caractères")
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colorResource(color.white),
                    unfocusedContainerColor = colorResource(color.white),
                    errorContainerColor = colorResource(color.white)
                )
            )

            Row(modifier = Modifier
                .clip(CutCornerShape(10.dp, 0.dp, 10.dp, 0.dp))
                .background(color = colorResource(id = color.deep_blue), shape = RectangleShape)
                .border(1.dp, color = colorResource(id = color.light_blue))
                .fillMaxWidth()
            ){
                Text(text = "S'inscrire",
                    fontFamily = fontAldrich,
                    modifier = Modifier.padding(20.dp).clickable(true, onClick = { /*TODO*/ }),
                    color = colorResource(id = color.light_blue)
                )
            }

        }
    }
}