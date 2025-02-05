package com.example.tp2navigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tp2navigationcompose.ui.theme.TP2NavigationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TP2NavigationComposeTheme {
                MaterialTheme {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("form") {
            FormScreen(navController = navController)
        }
        composable(
            route = "affForm/{name}/{age}",
            arguments = listOf(
                navArgument("name") { defaultValue = "John" },
                navArgument("age") { defaultValue = "25" }
            )
            ) { backStackEntry ->
                    val name = backStackEntry.arguments?.getString("name") ?: ""
                    val age = backStackEntry.arguments?.getString("age") ?: ""

                    AffForm(navController = navController, name = name, age = age)
            }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bienvenue dans ma première application compose navigation",
            style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.navigate( "form") }) {
            Text(text = "Accéder au formulaire")
        }
    }
}

@Composable
fun AffForm(navController: NavController, name: String, age: String) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text="Affichage de formulaire",
            style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = name, style = MaterialTheme.typography.titleMedium)

        Text(text = "Vous avez $age ans", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Retour")
        }
    }
}

@Composable
fun FormScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var name by remember { mutableStateOf("")}
        var age by remember { mutableStateOf("")}
        Text(text = "Page de formulaire",
            style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = name,
            onValueChange = { newText -> name = newText},
            label = { Text("Entrez votre nom") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        )

        TextField(
            value = age,
            onValueChange = { newText -> age = newText},
            label = { Text("Entrez votre âge") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick = { navController.navigate("affForm/$name/$age") }) {
            Text(text = "Valider")
        }

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Retour")
        }
    }
}