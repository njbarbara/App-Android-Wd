package com.sae.loupgarou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sae.loupgarou.data.api.RetrofitClient
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
import com.sae.loupgarou.pages.lobbies.LobbiesScreen
import com.sae.loupgarou.viewmodel.LobbiesViewModel
import com.sae.loupgarou.ui.theme.SettingsPage

val fontAldrich = FontFamily(
    Font(font.aldrich_regular, FontWeight.Normal)
)

class MainActivity : ComponentActivity() {

    // Bonne façon de déclarer une instance de ViewModel
    //private val lobbiesViewModel: LobbiesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        setContent {
            SAELoupGarouTheme {

                LobbiesScreen(viewModel = lobbiesViewModel)

                //Credits()

                //MainPage()
                //CreditsPage()
                //SettingsPage()
                //RulePage()
                //InscriptionPage()
                //ConnectionPage()
                CreationPage()
            }
        }
        
/*
        // 2. Préparation du ViewModel
        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return LobbiesViewModel(RetrofitClient.apiService) as T
            }
        }

        // 3. Lancement de l'interface
        setContent {
            // On récupère le ViewModel via notre factory
            val lobbiesViewModel: LobbiesViewModel = viewModel(factory = factory)

            // On lance la navigation principale
            SAELoupGarouTheme {
                LobbiesScreen(viewModel = lobbiesViewModel)
            }
        }
    }*/
    }
}

