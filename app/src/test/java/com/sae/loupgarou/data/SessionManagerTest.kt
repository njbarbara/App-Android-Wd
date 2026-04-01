package com.sae.loupgarou.data

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class SessionManagerTest {

    private lateinit var application: Application
    private lateinit var sessionManager: SessionManager

    @Before
    fun setUp() = runBlocking {
        application = ApplicationProvider.getApplicationContext()
        sessionManager = SessionManager(application)
        sessionManager.clearSession()
    }

    @After
    fun tearDown() = runBlocking {
        sessionManager.clearSession()
    }

    @Test
    fun saveToken_persistsTokenInDataStore() = runBlocking {
        sessionManager.saveToken("token-123")

        assertEquals("token-123", sessionManager.getToken())
        assertEquals("token-123", sessionManager.userToken.first())
    }

    @Test
    fun userToken_isNullWhenNoTokenIsSaved() = runBlocking {
        assertNull(sessionManager.getToken())
        assertNull(sessionManager.userToken.first())
    }

    @Test
    fun clearSession_removesSavedToken() = runBlocking {
        sessionManager.saveToken("token-123")

        sessionManager.clearSession()

        assertNull(sessionManager.getToken())
    }
}
