package com.example.laboratoriofirebase.view.notas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.laboratoriofirebase.viewmodel.NotesViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, ViewModel: NotesViewModel){

    Scaffold (topBar ={
        TopAppBar(title = { Text("Home") },
            navigationIcon = {
                IconButton(onClick = { ViewModel.signOut()
                    navController.navigate("login")}) {
                    Icon(imageVector= Icons.Default.ExitToApp, contentDescription = "")
                }
            })
    }){ innerPadding->Column(
        modifier = Modifier.padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    )   {
        Text("HOME")
        }
    }
}