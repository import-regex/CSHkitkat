package com.example.hellokitkat // Ensure this matches your package name

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
// If you enabled ViewBinding, import your generated binding class:
// import com.example.hellokitkat.databinding.ActivityMainBinding // Adjust to your package

class MainActivity : AppCompatActivity() {

    // If using ViewBinding:
    // private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Option 1: Traditional setContentView with R.layout
        setContentView(R.layout.activity_main)

        // Option 2: If using ViewBinding (preferred)
        // binding = ActivityMainBinding.inflate(layoutInflater)
        // setContentView(binding.root)

        // Now you can access views if using ViewBinding:
        // binding.myTextView.text = "Hello from API 17!"
        // binding.myButton.setOnClickListener { /* ... */ }

        // Or using findViewById (less safe, more boilerplate):
        // val myTextView: TextView = findViewById(R.id.my_text_view)
        // myTextView.text = "Hello from API 17!"
    }
}