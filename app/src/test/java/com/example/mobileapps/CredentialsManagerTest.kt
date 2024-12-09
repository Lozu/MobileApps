// Put your package name here. Check your activity for reference.
package com.example.mobileapps

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class CredentialsManagerTest {
    private val credentialsManager = CredentialsManager()
    @Test
    fun emptyEmail() {
        assertEquals(false, credentialsManager.isEmailValid(""))
    }

    @Test
    fun wrongEmailFormat() {
        assertEquals(false, credentialsManager.isEmailValid("@invalid"))
        assertEquals(false, credentialsManager.isEmailValid("test@te.st@invalid"))

    }

    @Test
    fun properEmails() {
        assertEquals(true, credentialsManager.isEmailValid("test@te.st"))
    }

    @Test
    fun emptyPassword() {
        assertEquals(false, credentialsManager.isPasswordValid(""))
    }
    @Test
    fun validPasswords() {
        assertEquals(true, credentialsManager.isPasswordValid("abc"))
        assertEquals(true, credentialsManager.isPasswordValid("1234"))
    }

    @Test
    fun correctCredentials() {
        assertEquals(true, credentialsManager.
            areCredentialsCorrect(
                credentialsManager.correct_email,
                credentialsManager.correct_password)
        )
    }

    @Test
    fun remembersCredentials() {
        val cm = CredentialsManager()
        assertEquals(true, cm.register("test@mail.com", "abc"))
        assertEquals(false, cm.register("test@mail.com", "ab"))

        assertEquals(true, cm.areCredentialsCorrect("test@mail.com", "abc"))
        assertEquals(false, cm.areCredentialsCorrect("test@mail.com", "ab"))
    }
}