package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val premierBouton : Button = findViewById(R.id.premierButton)
        premierBouton.setOnClickListener{
            val textView : TextView = findViewById(R.id.textView)
            val editText : EditText = findViewById(R.id.editTextText)
            val text = editText.text.toString()
            if (editText.text.isEmpty()) {
                textView.text = "Hello World!"
            } else if (text == "afficher nouveau textView") {
                val layoutPrincipal : ConstraintLayout = findViewById(R.id.main)
                val deuxiemeTextView : TextView = TextView(this)
                deuxiemeTextView.text = "Nouveau TextView"
                layoutPrincipal.addView(deuxiemeTextView)
            } else {
                textView.text = editText.text
            }
        }
    }
}