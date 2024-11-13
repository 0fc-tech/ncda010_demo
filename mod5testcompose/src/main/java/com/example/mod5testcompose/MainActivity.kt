package com.example.mod5testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod5testcompose.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PasswordField(Modifier.padding(innerPadding))
                }
            }
        }
    }
}


const val TEST_TAG_TEXTFIELD_PWD = "TextFieldPassword"

const val MONTRER_MOT_DE_PASSE = "Montrer mot de passe"

const val CACHER_MOT_DE_PASSE = "Cacher mot de passe"

@Composable
fun PasswordField(modifier :Modifier = Modifier) {

    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextField(
        modifier = modifier
            .fillMaxWidth()
            //permet d'ajouter des éléments spécifiques pour les tests
            //on peut les manipuler pedant les tests
            .testTag(TEST_TAG_TEXTFIELD_PWD),
        // .testTag(TEST_TAG_TEXTFIELD_PWD),
        value = password,
        onValueChange = { password = it },
        label = { Text("Mot de passe") },
        singleLine = true,
        //gère le changement de type input
        visualTransformation =
        if (passwordVisible)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType =
            KeyboardType.Password
        ),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.CheckCircle
            else Icons.Filled.Lock

            val description =
                if (passwordVisible)
                    CACHER_MOT_DE_PASSE
                else MONTRER_MOT_DE_PASSE


            IconButton(
                onClick = {
                    passwordVisible = !passwordVisible
                }) {
                Icon(imageVector = image, description)
            }
        }
    )
}