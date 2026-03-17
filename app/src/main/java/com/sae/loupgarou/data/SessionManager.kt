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
    }

    val userToken: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[USER_TOKEN]
    }

    suspend fun saveToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_TOKEN] = token
        }
    }

    suspend fun getToken(): String? {
        return userToken.first()
    }

    suspend fun clearToken() {
        context.dataStore.edit { preferences ->
            preferences.remove(USER_TOKEN)
        }
    }
}
