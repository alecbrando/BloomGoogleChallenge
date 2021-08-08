package com.alecbrando.bloom.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alecbrando.bloom.Components.Home.HomeScreen
import com.alecbrando.bloom.WelcomeScreen
import com.alecbrando.bloom.Components.LogInScreen.LoginScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "register_route"){
        composable("register_route"){
            WelcomeScreen(navController)
        }
        composable("login_route") {
            LoginScreen(navController)
        }
        composable("home_route") {
            HomeScreen(navController)
        }
    }
}