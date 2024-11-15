package com.example.mod7apirest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod7apirest.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeatherPage(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun WeatherPage(
    modifier: Modifier = Modifier,
    vm : WeatherVM = viewModel()
) {
    val weather = vm.weather.collectAsState().value
    LazyColumn(modifier) {
        weather?.let {
            itemsIndexed(it.time){index,time->
                Row(Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(time)
                    Text("${it.temperature_2m[index]}°C")
                }
                Spacer(Modifier.fillMaxWidth()
                    .background(Color.DarkGray)
                    .height(1.dp))
            }
        }
    }
}
