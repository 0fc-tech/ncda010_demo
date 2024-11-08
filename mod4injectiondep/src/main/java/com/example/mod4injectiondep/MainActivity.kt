package com.example.mod4injectiondep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod4injectiondep.ui.theme.TPTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListeLieux(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ListeLieux(modifier: Modifier = Modifier,
                vm: ListeLieuxVM = viewModel()
) {
    LazyColumn(modifier) {
        items(vm.stateLieux.value){
            Text(it,Modifier.padding(16.dp))
        }
    }
}