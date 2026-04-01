package com.sae.loupgarou.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_session")

class SessionManager(private val context: Context) {

    companion object {
        private val USER_TOKEN = stringPreferencesKey("user_token")
        private val USER_LOGIN = stringPreferencesKey("user_login")
    }

    val userToken: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[USER_TOKEN]
    }

    val userLogin: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[USER_LOGIN]
    }

    suspend fun saveSession(token: String, login: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_TOKEN] = token
            preferences[USER_LOGIN] = login
        }
    }

    suspend fun getToken(): String? {
        return userToken.first()
    }

    suspend fun getLogin(): String? {
        return userLogin.first()
    }

    suspend fun clearSession() {
        context.dataStore.edit { preferences ->
            preferences.remove(USER_TOKEN)
            preferences.remove(USER_LOGIN)
        }
    }
}
