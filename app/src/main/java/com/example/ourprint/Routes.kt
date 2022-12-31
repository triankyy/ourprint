package com.example.ourprint

sealed class Routes(val routes: String) {
    object Login: Routes("Login")
    object Register: Routes("Register")
}
