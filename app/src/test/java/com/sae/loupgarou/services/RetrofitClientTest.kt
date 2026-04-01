package com.sae.loupgarou.services

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertSame
import org.junit.Test

class RetrofitClientTest {

    @Test
    fun authApiService_isCreatedLazilyOnlyOnce() {
        val first = RetrofitClient.authApiService
        val second = RetrofitClient.authApiService

        assertNotNull(first)
        assertSame(first, second)
    }
}
