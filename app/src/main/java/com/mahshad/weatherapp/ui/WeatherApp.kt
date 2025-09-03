package com.mahshad.weatherapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun WeatherApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        modifier = Modifier.fillMaxSize(),
        startDestination = "login"
    ) {
        composable("login") {
            // Your Home Screen Composable
//            HomeScreen(
//                onNavigateToProfile = { navController.navigate("profile") }
//            )
        }
        composable("signup") {
            // Your Profile Screen Composable
//            ProfileScreen(
//                onNavigateBack = { navController.popBackStack() }
//            )
        }

    }
}