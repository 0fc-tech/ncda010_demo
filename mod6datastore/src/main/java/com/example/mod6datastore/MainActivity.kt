package com.example.mod6datastore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod6datastore.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SettingsPage(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun SettingsPage(
    modifier: Modifier = Modifier,
    vm : UserPrefVM = viewModel(factory = UserPrefVM.Factory)
) {
    val colors = vm.colors
    vm.getColorSelected()
    val colorSelected = vm.colorSelected.collectAsState().value

    Column(modifier.fillMaxSize().background(colorSelected)) {
        colors.forEach{color->
            Spacer(Modifier
                .background(color)
                .height(64.dp)
                .width(100.dp)
                .padding(8.dp)
                .clickable { vm.setColorSelected(color) }
            )
        }
    }
}