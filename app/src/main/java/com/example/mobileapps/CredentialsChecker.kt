package com.example.mobileapps

interface CredentialsChecker {
    fun isEmailValid(email: String): Boolean
    fun isPasswordValid(password: String): Boolean
    fun areCredentialsCorrect(email: String, password: String): Boolean
    fun execOnSuccess()
    fun moveToRegistration()
}