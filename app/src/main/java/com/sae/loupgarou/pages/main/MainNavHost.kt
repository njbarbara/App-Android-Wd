package com.sae.loupgarou.pages.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sae.loupgarou.pages.connection.ConnectionPage
import com.sae.loupgarou.pages.creation.CreationPage
import com.sae.loupgarou.pages.credits.CreditsPage
import com.sae.loupgarou.pages.home.HomePage
import com.sae.loupgarou.pages.inscription.InscriptionPage
import com.sae.loupgarou.pages.rules.RulePage
import com.sae.loupgarou.ui.theme.SettingsPage
import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    data object MainRoute

    @Serializable
    data object RulesRoute

    @Serializable
    data object SettingsRoute

    @Serializable
    data object InscriptionRoute

    @Serializable
    data object CreditsRoute

    @Serializable
    data object CreationRoute

    @Serializable
    data object ConnectionRoute

    @Serializable
    data object HomeRoute
}

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.CreditsRoute
    ){
        composable<Routes.MainRoute> {
            MainPage(
                onNavigateToConnection = { navController.navigate(Routes.ConnectionRoute) },
                onNavigateToInscription = { navController.navigate(Routes.InscriptionRoute)}
            )
        }

        composable<Routes.RulesRoute> {
            RulePage(
                onReturn = { navController.navigate(Routes.HomeRoute) }
            )
        }

        composable<Routes.SettingsRoute> {
            SettingsPage()
        }

        composable<Routes.InscriptionRoute> {
            InscriptionPage()
        }

        composable<Routes.CreditsRoute> {
            CreditsPage(onReturn = { navController.navigate(Routes.HomeRoute) })
        }

        composable<Routes.CreationRoute> {
            CreationPage(onReturn = { navController.navigate(Routes.HomeRoute) })
        }

        composable<Routes.ConnectionRoute> {
            ConnectionPage(
                onConnection = { navController.navigate(Routes.HomeRoute) }
            )
        }

        composable<Routes.HomeRoute>{
            HomePage()
        }
    }
}