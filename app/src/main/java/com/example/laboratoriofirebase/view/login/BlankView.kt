package com.example.laboratoriofirebase.view.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun BlankView(navController: NavController){
    LaunchedEffect(Unit) {
        if(!FirebaseAuth.getInstance().currentUser?.email.isNullOrBlank()) {
            navController.navigate("home")
        }else{
            navController.navigate("login")
        }
    }
}