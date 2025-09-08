package com.mahshad.weatherapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mahshad.authentication.navigation.authNavGraph
import com.mahshad.authentication.navigation.onNavigateToLogIn
import com.mahshad.authentication.navigation.onNavigateToSignUp
import com.mahshad.authentication.navigation.onSuccessLogIn
import com.mahshad.weatherapp.navigation.TopLevelDestinations

@Composable
fun WeatherAppNavHost(navController: NavHostController) {
    // The NavHost startDestination should be the route of the first
    // nested graph you want to display. Using `AuthRoute::class` here
    // is the correct way to start at the authentication graph.
    // Ensure your Navigation Compose library is up to date to support KClass routes.
    NavHost(
        navController = navController,
        modifier = Modifier.fillMaxSize(),
        startDestination = TopLevelDestinations.AUTH.baseRoute
    ) {
        // Includes the modular authentication graph
        authNavGraph(
            navController.onNavigateToSignUp,
            onNavigateToLogIn = navController.onNavigateToLogIn,
            onSuccessLogIn = navController.onSuccessLogIn,
        )

        // Includes the modular main app graph
    }
}