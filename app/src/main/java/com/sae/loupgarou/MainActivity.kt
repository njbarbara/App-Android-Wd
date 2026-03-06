package com.sae.loupgarou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.sae.loupgarou.R.font
import com.sae.loupgarou.ui.theme.SAELoupGarouTheme
import com.sae.loupgarou.pages.main.MainPage
import com.sae.loupgarou.pages.creation.CreationPage
import com.sae.loupgarou.pages.credits.CreditsPage
import com.sae.loupgarou.pages.connection.ConnectionPage
import com.sae.loupgarou.pages.inscription.InscriptionPage
import com.sae.loupgarou.pages.rules.RulePage
import com.sae.loupgarou.ui.theme.SettingsPage

val fontAldrich = FontFamily(
    Font(font.aldrich_regular, FontWeight.Normal)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SAELoupGarouTheme {
                //MainPage()
                //CreditsPage()
                //SettingsPage()
                //RulePage()
                //InscriptionPage()
                //ConnectionPage()
                CreationPage()
            }
        }
    }
}
