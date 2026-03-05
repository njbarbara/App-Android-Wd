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
import com.sae.loupgarou.ui.theme.SAELoupGarouTheme
import com.sae.loupgarou.pages.credits.Credits
import com.sae.loupgarou.pages.rules.RulePage
import com.sae.loupgarou.pages.lobbies.LobbiesScreen
import com.sae.loupgarou.viewmodel.LobbiesViewModel

class MainActivity : ComponentActivity() {

    // Bonne façon de déclarer une instance de ViewModel
    private val lobbiesViewModel: LobbiesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /*
        setContent {
            SAELoupGarouTheme {

                LobbiesScreen(viewModel = lobbiesViewModel)

                //Credits()
                //RulePage()
            }
        }
        */

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
    }
}