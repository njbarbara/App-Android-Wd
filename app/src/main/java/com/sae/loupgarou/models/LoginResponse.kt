package com.sae.loupgarou.models

data class User(val username: String, val email: String)
data class LoginResponse(val token: String, val message: String)
