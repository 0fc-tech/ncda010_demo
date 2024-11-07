package com.example.mod4compteur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.mod4compteur.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecetteCuisine(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun RecetteCuisine(modifier: Modifier = Modifier) {
    var nbOeufs by remember{ mutableIntStateOf(0) }
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically){
        IconButton(onClick = {
            nbOeufs-=1
        }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Down"
            )
        }
        Text("$nbOeufs")
        IconButton(onClick = {
            nbOeufs+=1
        }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = "Plus"
            )
        }

    }
}