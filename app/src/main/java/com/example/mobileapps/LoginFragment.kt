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
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment(R.layout.fragment_login) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var checker: CredentialsChecker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
            parentFragmentManager.beginTransaction()
                .replace(R.id.login_fragment, RegisterFragment())
                .commit()

        }

        button.setOnClickListener {
            val email = email_field.text.toString()
            val password = password_field.text.toString()

            if (!checker.isEmailValid(email)) {
                email_field.error = "Invalid email"
            } else if (!checker.isPasswordValid(password)) {
                password_field.error = "Empty password"
            } else if (checker.areCredentialsCorrect(email, password)) {
                startActivity(Intent(activity, MainActivity::class.java))
                activity?.finish()
            } else {
                button.text = "Invalid credentials. Try again"
                Log.d("login email", email)
                Log.d("login password", password)
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
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}