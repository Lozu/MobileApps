package com.example.mobileapps

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var checker: CredentialsChecker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        checker = context as CredentialsChecker
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val register = view.findViewById<TextView>(R.id.login_footer_link)
        val button = view.findViewById<MaterialButton>(R.id.login_button)
        val email_field = view.findViewById<TextInputEditText>(R.id.login_enter_email)
        val password_field = view.findViewById<TextInputEditText>(R.id.login_password)

        register.setOnClickListener {
            checker.moveToRegistration()
        }

        button.setOnClickListener {
            val email = email_field.text.toString()
            val password = password_field.text.toString()

            if (!checker.isEmailValid(email)) {
                email_field.error = "Invalid email"
            } else if (!checker.isPasswordValid(password)) {
                password_field.error = "Empty password"
            } else if (checker.areCredentialsCorrect(email, password)) {
                checker.execOnSuccess()
            } else {
                button.text = "Invalid credentials. Try again"
                Log.d("login email", email)
                Log.d("login password", password)
            }
        }
    }
}