package com.sae.loupgarou.data.api

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertSame
import org.junit.Test

class RetrofitClientTest {

    @Test
    fun apiService_isCreatedLazilyOnlyOnce() {
        val first = RetrofitClient.apiService
        val second = RetrofitClient.apiService

        assertNotNull(first)
        assertSame(first, second)
    }
}
