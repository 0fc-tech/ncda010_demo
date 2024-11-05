package com.example.mod3rowcolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.mod3rowcolumn.ui.theme.DemonstrationsTheme
import okhttp3.internal.notify

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RowColumn(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RowColumn(modifier: Modifier = Modifier) {
    Column(modifier = modifier){
        Text("En dessous de moi une Row 😁😁😁")
        Row{
            Text("Je suis le premier")
            Text("moi le second")
        }
        BoxImage()
    }
}

@Composable
fun BoxImage(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.border(5.dp,Color.Cyan),
        contentAlignment = Alignment.BottomEnd) {
        AsyncImage(
            model = "https://lh3.googleusercontent.com/dVFWOxJilOPLmmXagzr5TABxaI17eJDv6ZUsVIoie2F_uUJJt0KVBcxKVWcR91HAgVkj6OdfbJhlGlj_c6YHHHjX_C0DLV428etUggrxhG236Q=s0",
            contentDescription ="image profil"
        )
        Icon(imageVector= Icons.Default.AccountCircle,
            contentDescription = null,
            modifier = Modifier.padding(16.dp))
    }
}






