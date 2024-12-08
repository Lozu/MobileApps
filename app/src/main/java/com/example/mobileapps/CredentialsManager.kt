package com.example.mobileapps

class CredentialsManager {
    private val regex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}")
    val correct_email = "test@te.st"
    val correct_password = "1234"

    fun isEmailValid(email: String): Boolean {
        return regex.matches(email)
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length > 0
    }

    fun areCredentialsCorrect(email: String, password: String): Boolean {
        return email == correct_email && password == correct_password
    }
}