package com.example.firebaseauthdemoapp.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
//import com.example.firebaseauthdemoapp.AuthState
//import com.example.firebaseauthdemoapp.AuthViewModel
import com.example.firebaseauthdemoapp.ui.theme.AuthState
import com.example.firebaseauthdemoapp.ui.theme.AuthViewModel

@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {

    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Unauthenticated -> navController.navigate("login")
            else -> Unit
        }
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcom in this app now very happy you visit my app.", fontSize = 32.sp,color=Color.Red)

        TextButton(onClick = {
            authViewModel.signout()
        }) {
            Text(text = "Sign out")
        }
    }

}
