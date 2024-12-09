package com.example.mobileapps

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity(R.layout.activity_login), CredentialsChecker,
    CredentialsSaver {

    private val login_manager = CredentialsManager(true)

    init {
        Log.d("LoginActivity", "init")
    }

    override fun isEmailValid(email: String): Boolean {
        return login_manager.isEmailValid(email)
    }

    override fun isPasswordValid(password: String): Boolean {
        return login_manager.isPasswordValid(password)
    }

    override fun areCredentialsCorrect(email: String, password: String): Boolean {
        return login_manager.areCredentialsCorrect(email, password)
    }

    override fun register(email: String, password: String): Boolean {
        return login_manager.register(email, password)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.login_fragment, LoginFragment())
                .commit()
        }
        return
    }
}