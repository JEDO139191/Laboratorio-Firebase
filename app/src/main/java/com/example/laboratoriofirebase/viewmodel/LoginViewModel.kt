package com.example.laboratoriofirebase.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratoriofirebase.model.User
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    var showAlert by mutableStateOf(false)
    fun login(email: String, password: String, onSuccess: () -> Unit) {
        try {
            viewModelScope.launch {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                            onSuccess()//login success
                        } else {
                            Log.e("LoginViewModel", "login failed", task.exception)//login failed
                            showAlert=true
                        }
                    }

            }
        }catch (e: Exception){
            Log.e("LoginViewModel", "login failed", e)
            showAlert=true
        }
    }
    fun register(email: String, password: String, userName: String, onSuccess: () -> Unit) {
        try {
            viewModelScope.launch {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                            saveUser(userName)
                            onSuccess()//login success
                        } else {
                            Log.e("LoginViewModel", "Register failed", task.exception)//login failed
                            showAlert=true
                        }
                    }

            }
        }catch (e: Exception){
            Log.e("LoginViewModel", "Register failed", e)
            showAlert=true
        }
    }
    private fun saveUser(userName: String) {
        val id = auth.currentUser?.uid
        val email = auth.currentUser?.email

        viewModelScope.launch (Dispatchers.IO){
        val user = User(userId = id.toString(), email = email.toString(), name = userName)
        FirebaseFirestore.getInstance().collection("users").add(user.toMap())
            .addOnCompleteListener (){task->
                if(task.isSuccessful){
                    Log.d("LoginViewModel", "User saved")
                }else{
                    Log.e("LoginViewModel", "User not saved", task.exception)
                }

            }
        }
    }
    fun closeAlert(){
        showAlert=false
    }

}

