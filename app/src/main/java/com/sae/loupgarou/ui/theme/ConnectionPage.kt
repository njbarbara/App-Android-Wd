package com.sae.loupgarou.ui.theme


import android.util.Patterns
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
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
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation.Companion.None
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.R

val fontAldrich = FontFamily(
    Font(R.font.aldrich_regular, FontWeight.Normal)
)

@Composable
fun ConnectionPage() {
    var username by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }


    val isPasswordError = password.isNotEmpty() && password.length < 6


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.deep_marine))
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center
    ) {
        Column(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .border(
                    width = 2.dp,
                    color = colorResource(id = R.color.light_blue),
                    shape = CutCornerShape(10.dp)
                )
                .padding(horizontal = 25.dp, vertical = 40.dp),

            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "CONNEXION",
                fontFamily = fontAldrich,
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 20.dp)
            )

            AuthTextField(
                label = "NOM D'UTILISATEUR",
                value = username,
                onValueChange = { username = it }
            )


            AuthTextField(
                label = "MOT DE PASSE",
                value = password,
                onValueChange = { password = it },
                isError = isPasswordError,
                errorMessage = "Il faut au moins 6 caractères.",
                isPassword = true
            )


            Button(
                onClick = { /* TODO */ },
                shape = CutCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.light_blue))
            ) {
                Text("SE CONNECTER", fontFamily = fontAldrich, color = colorResource(id = R.color.deep_blue), modifier = Modifier.padding(vertical = 10.dp))
            }

            OutlinedButton(
                onClick = { username = ""
                            password = ""
                          },
                shape = CutCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth(),
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 2.dp, brush = androidx.compose.ui.graphics.SolidColor(colorResource(id = R.color.light_blue)))
            ) {
                Text("RÉINITIALISER", fontFamily = fontAldrich, color = colorResource(id = R.color.light_blue), modifier = Modifier.padding(vertical = 10.dp))
            }

            Row(modifier = Modifier.padding(top = 20.dp)) {
                Text("Pas de compte ? ", color = Color.White, fontFamily = fontAldrich)
                Text(
                    text = "S'inscrire",
                    color = colorResource(id = R.color.light_blue),
                    fontFamily = fontAldrich,
                    modifier = Modifier.clickable { /* TODO */ }
                )
            }
        }
    }
}

@Composable
private fun AuthTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean = false,
    errorMessage: String = "",
    isPassword: Boolean = false
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            color = colorResource(id = R.color.light_blue),
            fontFamily = fontAldrich,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = CutCornerShape(8.dp),
            isError = isError,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else None,
            supportingText = {
                if (isError) {
                    Text(errorMessage, color = Color.Red, fontFamily = fontAldrich)
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = colorResource(id = R.color.deep_blue),
                unfocusedContainerColor = colorResource(id = R.color.deep_blue),
                errorContainerColor = colorResource(id = R.color.deep_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue),
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                cursorColor = colorResource(id = R.color.light_blue),
                focusedTextColor = colorResource(id = R.color.light_blue),
                unfocusedTextColor = colorResource(id = R.color.light_blue),
                errorTextColor = colorResource(id = R.color.light_blue)
            )
        )
    }
}
