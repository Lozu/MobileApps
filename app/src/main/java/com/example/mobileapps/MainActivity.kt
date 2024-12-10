package com.example.mobileapps

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private var showingA = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentA())
                .commit()
        }

        val toggleButton = findViewById<Button>(R.id.toggle_button)
        toggleButton.setOnClickListener {
            val fragment = if (showingA) FragmentB() else FragmentA()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()

            showingA = !showingA
        }
    }
}
