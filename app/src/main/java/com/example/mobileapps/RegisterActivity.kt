package com.example.mobileapps

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView

class RegisterActivity : AppCompatActivity(R.layout.activity_register) {

    private val nameField: TextInputEditText
        get() = findViewById(R.id.register_name)
    private val phoneField: TextInputEditText
        get() = findViewById(R.id.register_phone_number)
    private val emailField: TextInputEditText
        get() = findViewById(R.id.register_email)
    private val passwordField: TextInputEditText
        get() = findViewById(R.id.register_password)
    private val button: MaterialButton
        get() = findViewById(R.id.register_button)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val login = findViewById<TextView>(R.id.register_footer_link)

        login.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        button.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (!State.login_manager.isEmailValid(email)) {
                emailField.error = "Invalid email"
            } else if (!State.login_manager.isPasswordValid(email)) {
                passwordField.error = "Empty password"
            } else {
                val result = State.login_manager.register(email, password)
                if (result) {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    button.text = "Email already taken"
                }
            }
        }
    }
}