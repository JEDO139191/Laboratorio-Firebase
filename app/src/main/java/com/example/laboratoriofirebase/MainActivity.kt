package com.example.laboratoriofirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratoriofirebase.navigation.NavManager
import com.example.laboratoriofirebase.ui.theme.LaboratorioFirebaseTheme
import com.example.laboratoriofirebase.view.login.TabsView
import com.example.laboratoriofirebase.viewmodel.LoginViewModel
import com.example.laboratoriofirebase.viewmodel.NotesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val loginViewModel : LoginViewModel by viewModels()
        val notesViewModel : NotesViewModel by viewModels()
        setContent {
            LaboratorioFirebaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavManager(loginViewModel=loginViewModel,
                        notesViewModel = notesViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaboratorioFirebaseTheme {
        Greeting("Android")
    }
}