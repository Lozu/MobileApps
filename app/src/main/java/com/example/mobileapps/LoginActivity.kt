package com.example.mobileapps

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class LoginActivity : AppCompatActivity(R.layout.activity_login) {
    private val login_manager: CredentialsManager
        get() = CredentialsManager()
    private val register: TextView
        get() = findViewById(R.id.login_footer_link)
    private val email_field: TextInputEditText
        get() = findViewById(R.id.login_enter_email)
    private val password_field: TextInputEditText
        get() = findViewById(R.id.login_password)
    private val button: MaterialButton
        get() = findViewById(R.id.login_button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        button.setOnClickListener {
            val email = email_field.text.toString()
            val password = password_field.text.toString()

            if (!login_manager.isEmailValid(email)) {
                email_field.error = "Invalid email"
            } else if (!login_manager.isPasswordValid(password)) {
                password_field.error = "Empty password"
            } else if (login_manager.areCredentialsCorrect(email, password)) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                button.text = "Invalid credentials. Try again"
            }
        }
    }
}