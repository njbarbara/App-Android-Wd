package com.sae.loupgarou.data

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SessionManagerInstrumentedTest {

    private lateinit var sessionManager: SessionManager

    @Before
    fun setUp() = runBlocking {
        val context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
        sessionManager = SessionManager(context)
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
    fun clearSession_removesSavedToken() = runBlocking {
        sessionManager.saveToken("token-123")

        sessionManager.clearSession()

        assertNull(sessionManager.getToken())
    }
}
