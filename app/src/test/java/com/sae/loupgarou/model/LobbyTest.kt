package com.sae.loupgarou.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class LobbyTest {

    @Test
    fun playerCount_returnsNumberOfPlayersInLobby() {
        val lobby = Lobby(
            id = 7,
            heureDeCreation = "2026-03-05T18:00:00Z",
            phase = "lobby",
            nbPlayerMax = 8,
            isEnded = false,
            players = listOf(
                PlayerInfo(username = "alice"),
                PlayerInfo(username = "bob"),
                PlayerInfo(username = "charlie")
            )
        )

        assertEquals(3, lobby.playerCount)
    }

    @Test
    fun defaultMetadata_isAppliedWhenNameAndDescriptionAreNotProvided() {
        val lobby = Lobby(
            id = 9,
            heureDeCreation = "2026-03-05T18:00:00Z",
            phase = "ended",
            nbPlayerMax = 12,
            isEnded = true,
            players = emptyList()
        )

        assertEquals("Salon ", lobby.nom)
        assertEquals("Partie classique", lobby.description)
        assertEquals(0, lobby.playerCount)
    }

    @Test
    fun explicitNullMetadata_isPreserved() {
        val lobby = Lobby(
            id = 10,
            heureDeCreation = "2026-03-05T18:00:00Z",
            phase = "playing",
            nbPlayerMax = 10,
            isEnded = false,
            players = listOf(PlayerInfo(username = "alice")),
            nom = null,
            description = null
        )

        assertNull(lobby.nom)
        assertNull(lobby.description)
    }
}
