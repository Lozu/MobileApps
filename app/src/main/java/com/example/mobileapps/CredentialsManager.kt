package com.example.mobileapps

class CredentialsManager {
    val regex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}")

    fun isEmailValid(email: String): Boolean {
        return regex.matches(email)
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length > 0
    }
}