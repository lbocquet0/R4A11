package com.example.tp2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.tp2.ui.theme.TP2Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
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
                        var name by remember { mutableStateOf("") }
                        var birthdate by remember { mutableStateOf("") }
                        BienvenueText(
                            modifier = Modifier.padding(innerPadding).padding(bottom = 16.dp)
                        )

                        NameText(
                            name = name,
                            modifier = Modifier.padding(innerPadding),
                        )

                        NameTextField(
                            name = name,
                            onNameChange = { newName -> name = newName },
                            modifier = Modifier.padding(innerPadding),
                        )

                        BirthDateField(
                            birthdate = birthdate,
                            onBirthdateChange = { newBirthdate -> birthdate = newBirthdate },
                            modifier = Modifier.padding(innerPadding),
                        )

                        ValidatButton(
                            modifier = Modifier.padding(innerPadding),
                            onClick = {
                                if (name.isEmpty() || birthdate.isEmpty()) {
                                    Toast.makeText(this@MainActivity, "Veuillez saisir votre nom", Toast.LENGTH_SHORT).show()
                                }

                                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                                intent.putExtra("name", name)
                                intent.putExtra("birthdate", birthdate)
                                startActivity(intent)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BienvenueText(modifier: Modifier = Modifier) {
    Text(
        text = "Bienvenue",
        modifier = modifier
    )
}

@Composable
fun NameText(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}

@Composable
fun NameTextField(name: String, onNameChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = name,
        onValueChange = onNameChange,
        label = { Text("Saisir votre nom") },
        modifier = modifier
    )
}

@Composable
fun BirthDateField(birthdate: String, onBirthdateChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = birthdate,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = onBirthdateChange,
        label = { Text("Saisir votre date de naissance") },
        modifier = modifier
    )
}

@Composable
fun ValidatButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = {
            onClick()
        },
        modifier = modifier
    ) {
        Text("Valider")
    }
}

/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TP2Theme {
        Greeting("Android")
    }
}*/