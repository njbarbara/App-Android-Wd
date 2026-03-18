package com.sae.loupgarou.pages.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sae.loupgarou.pages.GameSelection.GameSelectionPage
import com.sae.loupgarou.pages.connection.ConnectionPage
import com.sae.loupgarou.pages.creation.CreationPage
import com.sae.loupgarou.pages.credits.CreditsPage
import com.sae.loupgarou.pages.historique.HistoriquePage
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

    @Serializable
    data object ProfileRoute

    @Serializable
    data object PlayRoute

    @Serializable
    data object HistoryRoute

    @Serializable
    data object GameSelectionRoute
}

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.HistoryRoute
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
            InscriptionPage(
                onInscription = { navController.navigate(Routes.HomeRoute) },
                onConnection = { navController.navigate(Routes.HomeRoute) }
            )
        }

        composable<Routes.CreditsRoute> {
            CreditsPage(onReturn = { navController.navigate(Routes.HomeRoute) })
        }

        composable<Routes.CreationRoute> {
            CreationPage(onReturn = { navController.navigate(Routes.HomeRoute) })
        }

        composable<Routes.ConnectionRoute> {
            ConnectionPage(
                onConnection = { navController.navigate(Routes.HomeRoute) },
                onReturn = { navController.navigate(Routes.MainRoute) }
            )
        }

        composable<Routes.GameSelectionRoute>{
            GameSelectionPage(
                onCreateButtonClick = { navController.navigate(Routes.CreationRoute) },
                onJoinButtonClick = { /*navController.navigate(Routes.LobbyRoute)*/ },
                onReturn = { navController.navigate(Routes.HomeRoute) }
            )
        }

        composable<Routes.HistoryRoute>{
            HistoriquePage()
        }
        composable<Routes.HomeRoute>{

            HomePage(
                onSettingsClick = { navController.navigate(Routes.SettingsRoute) },
                onProfileClick = { navController.navigate(Routes.ProfileRoute) },
                onPlayClick = { navController.navigate(Routes.GameSelectionRoute) },
                onHistoryClick = { navController.navigate(Routes.HistoryRoute) },
                onRulesClick = { navController.navigate(Routes.RulesRoute) },
                onCreditsClick = { navController.navigate(Routes.CreditsRoute) }
            )
        }
    }
}