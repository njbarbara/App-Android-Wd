package com.sae.loupgarou.viewmodel

import com.example.example_project.data.api.ApiService
import com.sae.loupgarou.model.Lobby
import com.sae.loupgarou.model.PlayerInfo
import com.sae.loupgarou.testutils.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LobbiesViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun init_fetchesLobbiesFromApi() = runTest(mainDispatcherRule.dispatcher.scheduler) {
        val expectedLobbies = listOf(
            createLobby(id = 1, playerNames = listOf("alice", "bob")),
            createLobby(id = 2, playerNames = listOf("charlie"))
        )
        val api = FakeApiService(responses = mutableListOf(expectedLobbies))

        val viewModel = LobbiesViewModel(api)
        advanceUntilIdle()

        assertEquals(1, api.getLobbiesCalls)
        assertEquals(expectedLobbies, viewModel.lobbies.value)
    }

    @Test
    fun fetchLobbies_refreshesStateWhenCalledAgain() = runTest(mainDispatcherRule.dispatcher.scheduler) {
        val firstResult = listOf(createLobby(id = 1, playerNames = listOf("alice")))
        val refreshedResult = listOf(
            createLobby(id = 2, playerNames = listOf("bob", "charlie")),
            createLobby(id = 3, playerNames = listOf("diane"))
        )
        val api = FakeApiService(responses = mutableListOf(firstResult, refreshedResult))

        val viewModel = LobbiesViewModel(api)
        advanceUntilIdle()

        viewModel.fetchLobbies()
        advanceUntilIdle()

        assertEquals(2, api.getLobbiesCalls)
        assertEquals(refreshedResult, viewModel.lobbies.value)
    }

    @Test
    fun fetchLobbies_whenApiFails_keepsStateEmpty() = runTest(mainDispatcherRule.dispatcher.scheduler) {
        val api = FakeApiService(throwOnCalls = setOf(1))

        val viewModel = LobbiesViewModel(api)
        advanceUntilIdle()

        assertEquals(1, api.getLobbiesCalls)
        assertTrue(viewModel.lobbies.value.isEmpty())
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
