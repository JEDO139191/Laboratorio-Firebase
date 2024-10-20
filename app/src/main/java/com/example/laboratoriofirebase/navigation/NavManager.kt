package com.example.laboratoriofirebase.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratoriofirebase.view.login.BlankView
import com.example.laboratoriofirebase.view.login.LoginView
import com.example.laboratoriofirebase.view.login.TabsView
import com.example.laboratoriofirebase.view.notas.HomeView
import com.example.laboratoriofirebase.viewmodel.LoginViewModel
import com.example.laboratoriofirebase.viewmodel.NotesViewModel

@Composable
fun NavManager(loginViewModel: LoginViewModel, notesViewModel: NotesViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "blank") {
        composable ("blank"){
            BlankView(navController = navController)
        }
        composable("login") {
            TabsView(navController = navController, loginViewModel = LoginViewModel())        }
        composable("home") {
            HomeView(navController = navController, ViewModel = notesViewModel)
        }
    }
}