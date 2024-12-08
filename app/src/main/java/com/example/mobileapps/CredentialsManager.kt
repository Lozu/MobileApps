package com.example.mobileapps

import android.util.Log

class CredentialsManager(__debug: Boolean = false) {
    private val regex = Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}")
    val correct_email = "test@te.st"
    val correct_password = "1234"
    var credentials: MutableMap<String, String> = mutableMapOf(correct_email to correct_password)
    val debug: Boolean

    init {
        debug = __debug
        if (debug)
            Log.d("manager", "init")
    }

    fun printMap() {
        Log.d("mapsize", credentials.size.toString())
        credentials.forEach({ (k, v) ->  Log.d("saved", "[" + k + "/" + v + "]") })
    }

    fun isEmailValid(email: String): Boolean {
        return regex.matches(email)
    }

    fun isPasswordValid(password: String): Boolean {
        return password.length > 0
    }

    fun areCredentialsCorrect(email: String, password: String): Boolean {
        val res = credentials[email];

        if (debug) {
            printMap()
            Log.d(
                "result", if (res == null) {
                    "null"
                } else {
                    res.toString()
                }
            )
        }
        return res == password
    }

    fun register(email: String, password: String): Boolean {
        if (credentials[email] == null) {
            credentials.put(email, password)
            if (debug)
               printMap()
            return true;
        } else {
            return false;
        }
    }
}