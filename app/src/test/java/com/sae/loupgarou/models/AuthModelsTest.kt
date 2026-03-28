package com.sae.loupgarou.models

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class AuthModelsTest {

    @Test
    fun loginRequest_storesCredentials() {
        val request = LoginRequest(login = "alice", password = "secret")

        assertEquals("alice", request.login)
        assertEquals("secret", request.password)
    }

    @Test
    fun loginResponse_exposesTokenAndMessage() {
        val response = LoginResponse(token = "jwt-token", message = "ok")

        assertEquals("jwt-token", response.token)
        assertEquals("ok", response.message)
    }

    @Test
    fun registerRequest_storesLoginPasswordAndEmail() {
        val request = RegisterRequest(login = "alice", password = "secret", email = "alice@example.com")

        assertEquals("alice", request.login)
        assertEquals("secret", request.password)
        assertEquals("alice@example.com", request.email)
    }

    @Test
    fun registerResponse_exposesTokenAndMessage() {
        val response = RegisterResponse(token = "jwt-token", message = "created")

        assertEquals("jwt-token", response.token)
        assertTrue(response.message.contains("created"))
    }
}
