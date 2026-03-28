package com.sae.loupgarou.models

import kotlinx.serialization.Serializable

@Serializable
data class GamePlayer(
    val username: String,
    val email: String,
    val pfp: String,
    val choice: String,
    val isDead: Boolean,
    val isHost: Boolean
)

@Serializable
data class Game(
    val id: Int,
    val heureDeCreation: String,
    val players: List<GamePlayer>,
    val phase: String,
    val nbPlayerMax: Int,
    val result: String,
    val isEnded: Boolean,
    val nightCounts: Int
) {
    companion object {
        val stubs = listOf(
            Game(
                id = 1,
                heureDeCreation = "11:55",
                players = listOf(GamePlayer("neil", "neil1@gmail.com", "default.png", "none", false, true)),
                phase = "night",
                nbPlayerMax = 8,
                result = "Victoire",
                isEnded = false,
                nightCounts = 0
            ),
            Game(
                id = 2,
                heureDeCreation = "12:08",
                players = listOf(GamePlayer("najib", "koraseg976@bitoini.com", "default.png", "none", false, true)),
                phase = "night",
                nbPlayerMax = 8,
                result = "Victoire",
                isEnded = false,
                nightCounts = 0
            ),
            Game(
                id = 15,
                heureDeCreation = "17:32",
                players = listOf(
                    GamePlayer("cyril", "cyril.barrallon@gmail.com", "default.png", "none", false, true),
                    GamePlayer("Cyril 2", "cyvoli.jeux@gmail.com", "default.png", "none", true, false)
                ),
                phase = "night",
                nbPlayerMax = 8,
                result = "Victoire",
                isEnded = false,
                nightCounts = 0
            ),
            Game(
                id = 17,
                heureDeCreation = "11:55",
                players = listOf(GamePlayer("anis", "anis@gmail.com", "default.png", "none", false, true)),
                phase = "night",
                nbPlayerMax = 8,
                result = "défaite",
                isEnded = false,
                nightCounts = 0
            )
        )
    }
}
