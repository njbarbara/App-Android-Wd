package com.sae.loupgarou.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sae.loupgarou.data.SessionManager
import com.sae.loupgarou.data.api.UserApiService
import com.sae.loupgarou.models.PreviousGame
import com.sae.loupgarou.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val api: UserApiService,
    private val sessionManager: SessionManager
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()

    private val _lastGame = MutableStateFlow<PreviousGame?>(null)
    val lastGame: StateFlow<PreviousGame?> = _lastGame.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        fetchProfileData()
    }

    fun fetchProfileData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val token = sessionManager.getToken()
                if (token != null) {
                    val bearerToken = "Bearer $token"
                    val userInfo = api.getUserMe(bearerToken)
                    _user.value = userInfo

                    val games = api.getPreviousGames(userInfo.username)
                    if (games.isNotEmpty()) {
                        _lastGame.value = games.first()
                    }
                }
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
}
