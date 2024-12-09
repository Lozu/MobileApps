package com.example.mobileapps

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class RegisterFragment : Fragment() {
    private lateinit var saver: CredentialsSaver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        saver = context as CredentialsSaver
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val login = view.findViewById<TextView>(R.id.register_footer_link)
        val button = view.findViewById<MaterialButton>(R.id.register_button)
        val emailField = view.findViewById<TextInputEditText>(R.id.register_email)
        val passwordField = view.findViewById<TextInputEditText>(R.id.register_password)

        login.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.login_fragment, LoginFragment())
                .commit()
        }

        button.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (!saver.isEmailValid(email)) {
                emailField.error = "Invalid email"
            } else if (!saver.isPasswordValid(password)) {
                passwordField.error = "Empty password"
            } else {
                val result = saver.register(email, password)
                if (result) {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.login_fragment, LoginFragment())
                        .commit()
                } else {
                    button.text = "Email already taken"
                }
            }
        }
    }
}