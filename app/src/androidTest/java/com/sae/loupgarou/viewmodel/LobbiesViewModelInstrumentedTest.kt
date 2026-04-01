package com.sae.loupgarou.viewmodel

import android.os.SystemClock
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.example_project.data.api.ApiService
import com.sae.loupgarou.model.Lobby
import com.sae.loupgarou.model.PlayerInfo
import org.junit.Assert.fail
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LobbiesViewModelInstrumentedTest {

    @Test
    fun init_fetchesLobbiesFromApi() {
        val expectedLobbies = listOf(
            createLobby(id = 1, playerNames = listOf("alice", "bob")),
            createLobby(id = 2, playerNames = listOf("charlie"))
        )
        val api = FakeApiService(responses = mutableListOf(expectedLobbies))
        lateinit var viewModel: LobbiesViewModel

        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            viewModel = LobbiesViewModel(api)
        }
        waitUntil { viewModel.lobbies.value == expectedLobbies }

        assertEquals(1, api.getLobbiesCalls)
        assertEquals(expectedLobbies, viewModel.lobbies.value)
    }

    @Test
    fun fetchLobbies_refreshesStateWhenCalledAgain() {
        val firstResult = listOf(createLobby(id = 1, playerNames = listOf("alice")))
        val refreshedResult = listOf(
            createLobby(id = 2, playerNames = listOf("bob", "charlie")),
            createLobby(id = 3, playerNames = listOf("diane"))
        )
        val api = FakeApiService(responses = mutableListOf(firstResult, refreshedResult))
        lateinit var viewModel: LobbiesViewModel

        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            viewModel = LobbiesViewModel(api)
        }
        waitUntil { viewModel.lobbies.value == firstResult }

        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            viewModel.fetchLobbies()
        }
        waitUntil { viewModel.lobbies.value == refreshedResult }

        assertEquals(2, api.getLobbiesCalls)
        assertEquals(refreshedResult, viewModel.lobbies.value)
    }

    @Test
    fun fetchLobbies_whenApiFails_keepsStateEmpty() {
        val api = FakeApiService(throwOnCalls = setOf(1))
        lateinit var viewModel: LobbiesViewModel

        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            viewModel = LobbiesViewModel(api)
        }
        waitUntil { api.getLobbiesCalls == 1 }

        assertTrue(viewModel.lobbies.value.isEmpty())
    }

    private fun waitUntil(
        timeoutMs: Long = 2_000,
        condition: () -> Boolean
    ) {
        val endTime = SystemClock.elapsedRealtime() + timeoutMs
        while (!condition()) {
            if (SystemClock.elapsedRealtime() >= endTime) {
                fail("Condition was not met within $timeoutMs ms")
            }
            InstrumentationRegistry.getInstrumentation().waitForIdleSync()
            Thread.sleep(25)
        }
    }

    private fun createLobby(id: Int, playerNames: List<String>) = Lobby(
        id = id,
        heureDeCreation = "2026-03-05T18:00:00Z",
        phase = "lobby",
        nbPlayerMax = 12,
        isEnded = false,
        players = playerNames.map(::PlayerInfo),
        nom = "Lobby $id",
        description = "Description $id"
    )

    private class FakeApiService(
        private val responses: MutableList<List<Lobby>> = mutableListOf(),
        private val throwOnCalls: Set<Int> = emptySet()
    ) : ApiService {

        var getLobbiesCalls: Int = 0
            private set

        override suspend fun getLobbies(): List<Lobby> {
            getLobbiesCalls++
            if (throwOnCalls.contains(getLobbiesCalls)) {
                throw IllegalStateException("API indisponible")
            }

            return responses.removeFirstOrNull() ?: emptyList()
        }
    }
}
