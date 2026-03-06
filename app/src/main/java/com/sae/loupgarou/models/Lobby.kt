/*
//Problème de sérialization, classe pas compatible avec le JSON API
package com.sae.loupgarou.model

@Serializable
data class Lobby(
    val id: Int,
    val players : Int,
    val heureDeCreation: String,
    val nom: String,
    val description: String,
    val phase: String,
    val nbPlayerMax: Int,
    val isEnded: Boolean
)
*/

package com.sae.loupgarou.models

import kotlinx.serialization.Serializable

// Un player pour pouvoir compter le nombre de player dans le lobby
@Serializable
data class PlayerInfo(
    val username: String
)

@Serializable
data class Lobby(
    val id: Int,
    val heureDeCreation: String,
    val phase: String,
    val nbPlayerMax: Int,
    val isEnded: Boolean,
    val players: List<PlayerInfo>, // On récupère la liste...

    // Valeurs par défaut pour ne pas casser ton affichage
    val nom: String? = "Salon ",
    val description: String? = "Partie classique"
) {
    // ASTUCE : Une variable calculée à la volée pour ton UI
    val playerCount: Int get() = players.size
}