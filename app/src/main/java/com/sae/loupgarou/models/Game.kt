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
data class PreviousGame(
    val gameDate: String,
    val result: String?,
    val rolePlayed: String,
    val nightsCount: Int
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
)
