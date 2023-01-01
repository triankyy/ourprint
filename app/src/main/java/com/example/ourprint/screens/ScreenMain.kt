package com.example.ourprint.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ourprint.Routes

@Composable
fun ScreenMain() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = Routes.Login.routes) {
        composable(Routes.Login.routes) { LoginPage(navController) }
        composable(Routes.Register.routes) { RegisterPage(navController) }
        composable(Routes.Home.routes) { HomePage(navController) }
    }
}