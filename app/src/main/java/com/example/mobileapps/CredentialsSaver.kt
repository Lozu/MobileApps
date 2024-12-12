package com.example.mobileapps

interface CredentialsSaver : CredentialsChecker {
    fun register(email: String, password: String): Boolean
    fun moveToLogin()
}