package com.sae.loupgarou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sae.loupgarou.pages.authentification.connection.ConnectionPage
import com.sae.loupgarou.pages.authentification.inscription.InscriptionPage
import com.sae.loupgarou.ui.theme.SAELoupGarouTheme

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
                InscriptionPage()
                //ConnectionPage()
            }
        }
    }
}
