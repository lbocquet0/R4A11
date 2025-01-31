package com.example.tp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tp2.ui.theme.TP2Theme
import com.example.tp2.controller.AgeCalculator

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val name = intent.getStringExtra("name")
        val birthdate = intent.getStringExtra("birthdate")
        if (name.isNullOrEmpty() || birthdate.isNullOrEmpty()) {
            finish()
            return
        }

        val age = AgeCalculator.calculateAge(birthdate)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TP2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (
                        modifier = Modifier.fillMaxSize().padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Bienvenue(
                            name = name,
                            age = age,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Bienvenue(name: String, age: Int, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name, vous avez $age ans!",
        modifier = modifier
    )
}
