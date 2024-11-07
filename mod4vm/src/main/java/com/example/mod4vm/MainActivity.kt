package com.example.mod4vm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod4vm.ui.theme.DemonstrationsTheme
import kotlin.math.log

private const val TAG = "MainActivity"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RatingScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RatingScreen(
    modifier: Modifier = Modifier,
    vm : RatingViewModel = viewModel()
) {
   /* val value by remember{ mutableStateOf(
        SliderState(
            value = 0F,
            steps = 9,
            valueRange = 0f..10f,
        ),
    )}*/
    val rating = vm.rating.collectAsState()
    Column(modifier) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Button({
                vm.decrementRating()
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Down"
                )
            }
            Spacer(Modifier.width(8.dp))
            Text("${rating.value}")
            Spacer(Modifier.width(8.dp))

            Button({
                vm.incrementRating()
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "up"
                )
            }
        }

        //if(vm.infoUser.collectAsState().value.isNotBlank())
        //    Text(vm.infoUser.collectAsState().value)
        if(vm.requireFeedback.collectAsState().value)
            TextField(value = "", label = {
                Text("Qu'est ce qui s'est mal passé?")
            }, onValueChange = {})
    }
}