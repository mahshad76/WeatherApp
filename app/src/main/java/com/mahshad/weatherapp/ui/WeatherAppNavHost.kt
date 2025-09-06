package com.mahshad.weatherapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mahshad.authentication.navigation.AuthRoute
import com.mahshad.authentication.navigation.authNavGraph
import com.mahshad.authentication.navigation.onNavigateToLogIn
import com.mahshad.authentication.navigation.onNavigateToSignUp
import com.mahshad.authentication.navigation.onSuccessLogIn

@Composable
fun WeatherAppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        modifier = Modifier.fillMaxSize(),
        startDestination = AuthRoute
    ) {
        authNavGraph(
            navController.onNavigateToSignUp,
            onNavigateToLogIn = navController.onNavigateToLogIn,
            onSuccessLogIn = navController.onSuccessLogIn,
        )
    }
}