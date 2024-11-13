package com.example.mod5nav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mod5nav.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHostApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    Text("Hello, Bienvenue !")
}

@Composable
fun SignInPage(modifier: Modifier = Modifier,onClickToHome : ()->Unit) {
    Scaffold(Modifier.padding(16.dp)) {innerPadding->

        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text("Connectez-vous", style =
            MaterialTheme.typography.headlineMedium)
            TextField(
                modifier=Modifier.fillMaxWidth(),
                value = "Steve Travail",
                onValueChange = {})
            TextField(
                modifier=Modifier.fillMaxWidth(),
                value = "•••••••••",
            onValueChange = {}
            )
            OutlinedButton(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxWidth(),
                onClick = {
                    onClickToHome()
                }
            ) {
                Text("Se Connecter")
            }
        }
    }
}

@Composable
fun NavHostApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination :String = "signin"
) {
    NavHost(modifier=modifier,navController = navController,
        startDestination =startDestination) {
        composable("signin") {
            SignInPage(onClickToHome = {
                navController.navigate("home")
            })
        }
        composable("home") {
            HomePage()
        }
    }
}