package com.example.laboratoriofirebase.view.login


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.laboratoriofirebase.components.Alert
import com.example.laboratoriofirebase.viewmodel.LoginViewModel

@Composable
fun RegisterView(navController: NavController, loginViewModel: LoginViewModel){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var userName by remember { mutableStateOf("") }

        OutlinedTextField(value = userName,
            onValueChange =  {userName = it},
            label = {Text("Nombre del usuario")},
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
        )
        OutlinedTextField(value = email,
            onValueChange =  {email = it},
            label = {Text("email")},
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
        )
        OutlinedTextField(value = password,
            onValueChange =  {password = it},
            label = {Text("Password")},
            keyboardOptions=KeyboardOptions(keyboardType=KeyboardType.Password),
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick ={loginViewModel.register(email= email, password = password,userName = userName){
            navController.navigate("home")
        } },
            modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp))
        { Text("Registrar") }
        if(loginViewModel.showAlert){
            Alert(title = "Alerta",
                message = "Error en el registro",
                confirm = "Aceptar",
                onConfirm = {loginViewModel.closeAlert()}){}
        }
    }
    /*Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var repeatPassword by remember { mutableStateOf("") }
        var nombre by remember { mutableStateOf("") }
        var edad by remember { mutableStateOf("") }
        var sexo by remember { mutableStateOf("") }
        var showDialog by remember { mutableStateOf(false) }


        Spacer(Modifier.height(10.dp))

            Text("Ingrese sus datos")
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
            )

            OutlinedTextField(
                value = edad,
                onValueChange = { edad = it },
                label = { Text("Edad") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
            )
            Text("Seleccione su sexo:")
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 30.dp, end = 30.dp)
            ) {
                RadioButton(
                    selected = sexo == "Masculino",
                    onClick = { sexo = "Masculino" }
                )
                Text("Masculino", modifier = Modifier.padding(start = 8.dp))

                Spacer(modifier = Modifier.width(16.dp))

                RadioButton(
                    selected = sexo == "Femenino",
                    onClick = { sexo = "Femenino" }
                )
                Text("Femenino", modifier = Modifier.padding(start = 8.dp))
            }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
            )
            OutlinedTextField(
                value = repeatPassword,
                onValueChange = { repeatPassword = it },
                label = { Text("Escriba la contraseña nuevamente") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    if (password != repeatPassword) {
                        showDialog = true // Mostrar pop-up si las contraseñas no coinciden
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp)
            )
            { Text("Registrar") }
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Error") },
                    text = { Text("Las contraseñas no coinciden. Por favor, intente de nuevo.") },
                    confirmButton = {
                        Button(
                            onClick = { showDialog = false }
                        ) {
                            Text("Aceptar")
                        }
                    }
                )
            }



    }*/


}