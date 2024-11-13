package com.example.mod5activites

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mod5activites.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val permissionLauncher = rememberLauncherForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) {isGranted->
                if(isGranted)
                    context.startActivity(
                        Intent(Intent.ACTION_CALL,
                            Uri.parse("tel:0823456789")
                        )
                    )
            }
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)){
                        Button({
                            context.startActivity(
                                Intent(context,TargetActivity::class.java)
                            )
                        }) {
                            Text("Aller à Target")
                        }
                        Button({
                            context.startActivity(
                                Intent(Intent.ACTION_VIEW,
                                    Uri.parse("sms:0123456789")
                                )
                            )
                        }) {
                            Text("Aller à Télphone")
                        }
                        Button({
                            permissionLauncher.launch(
                                android.Manifest.permission.CALL_PHONE
                            )
                        }){
                            Text("Appeler Michel (tu me dois 4k€)")
                        }
                    }
                }
            }
        }
    }
}
