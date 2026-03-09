package com.sae.loupgarou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sae.loupgarou.data.api.RetrofitClient
import com.sae.loupgarou.pages.connection.ConnectionPage
import com.sae.loupgarou.pages.creation.CreationPage
import com.sae.loupgarou.pages.credits.CreditsPage
import com.sae.loupgarou.pages.home.HomePage
import com.sae.loupgarou.pages.main.MainPage
import com.sae.loupgarou.pages.inscription.InscriptionPage
import com.sae.loupgarou.ui.theme.SAELoupGarouTheme
import com.sae.loupgarou.pages.lobbies.LobbiesScreen
import com.sae.loupgarou.pages.rules.Rules
import com.sae.loupgarou.viewmodel.LobbiesViewModel

class MainActivity : ComponentActivity() {

    // 💡 On déclare le ViewModel UNE SEULE FOIS ici, en lui passant directement la Factory
    private val lobbiesViewModel: LobbiesViewModel by viewModels {
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                // On injecte le service Retrofit dans le ViewModel
                return LobbiesViewModel(RetrofitClient.apiService) as T            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Lancement de l'interface
        setContent {
            SAELoupGarouTheme {
                // On passe le ViewModel (qui a maintenant accès à l'API) à ton écran
                LobbiesScreen(viewModel = lobbiesViewModel)
                //CreditsPage()
                //HomePage()
                //CreationPage()
                //ConnectionPage()
                //InscriptionPage()
                //MainPage()
                //Rules()

            }
        }
    }
}