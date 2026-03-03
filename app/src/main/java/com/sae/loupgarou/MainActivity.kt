package com.sae.loupgarou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sae.loupgarou.ui.theme.SAELoupGarouTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SAELoupGarouTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

// Définition de tes couleurs "Wolves of Democracy"
val Cyan400 = Color(0xFF22D3EE)
val Slate900 = Color(0xFF0F172A)

// Définition de ta police (assure-toi d'avoir mis aldrich.ttf dans res/font)
val AldrichFont = FontFamily(Font(R.font.aldrich))

@Composable
fun LoginScreen() {
    // L'équivalent de x-data (la "mémoire" des champs)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Fond d'écran
        Image(
            painter = painterResource(id = R.drawable.earth), // Ton image dans res/drawable
            contentDescription = "Fond d'écran",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Conteneur principal (La forme sci-fi)
        Box(
            modifier = Modifier
                .padding(24.dp)
                .border(2.dp, Cyan400, CutCornerShape(topStart = 24.dp, bottomEnd = 24.dp))
                .background(Slate900.copy(alpha = 0.9f), CutCornerShape(topStart = 24.dp, bottomEnd = 24.dp))
                .padding(32.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Titre
                Text(
                    text = "IDENTIFICATION",
                    fontFamily = AldrichFont,
                    color = Color.White,
                    fontSize = 32.sp,
                    letterSpacing = 2.sp
                )

                Text(
                    text = "Accès au réseau sécurisé",
                    fontFamily = AldrichFont,
                    color = Cyan400,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Champ Email
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Adresse Email", color = Cyan400) },
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontFamily = AldrichFont),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Cyan400,
                        unfocusedBorderColor = Cyan400.copy(alpha = 0.5f),
                        cursorColor = Cyan400
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                // Champ Mot de passe
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Mot de passe", color = Cyan400) },
                    visualTransformation = PasswordVisualTransformation(),
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontFamily = AldrichFont),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Cyan400,
                        unfocusedBorderColor = Cyan400.copy(alpha = 0.5f),
                        cursorColor = Cyan400
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Bouton Connexion
                Button(
                    onClick = { /* Action de connexion ici */ },
                    shape = CutCornerShape(topStart = 12.dp, bottomEnd = 12.dp), // Coins coupés sci-fi
                    colors = ButtonDefaults.buttonColors(containerColor = Cyan400),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                ) {
                    Text(
                        text = "SE CONNECTER",
                        fontFamily = AldrichFont,
                        color = Slate900,
                        fontSize = 18.sp,
                        letterSpacing = 1.sp
                    )
                }
            }
        }
    }
}
