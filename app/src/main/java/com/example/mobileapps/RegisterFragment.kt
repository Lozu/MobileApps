package com.example.mobileapps

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var saver: CredentialsSaver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
            } else if (!saver.isPasswordValid(email)) {
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}