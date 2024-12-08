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
}