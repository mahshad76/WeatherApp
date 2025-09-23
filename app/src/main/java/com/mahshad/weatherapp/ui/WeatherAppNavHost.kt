package com.mahshad.weatherapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mahshad.authentication.navigation.authNavGraph
import com.mahshad.authentication.navigation.onNavigateToLogIn
import com.mahshad.authentication.navigation.onNavigateToSignUp
import com.mahshad.dashboard.navigation.dashBoardGraph
import com.mahshad.dashboard.navigation.navigateToCurrentWeather
import com.mahshad.dashboard.navigation.navigateToForecast
import com.mahshad.weatherapp.navigation.TopLevelDestinations

@Composable
fun WeatherAppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        modifier = Modifier.fillMaxSize(),
        startDestination = TopLevelDestinations.AUTH.baseRoute
    ) {
        authNavGraph(
            navController.onNavigateToSignUp,
            onNavigateToLogIn = navController.onNavigateToLogIn,
            onSuccessLogIn = { navController.navigate(TopLevelDestinations.DASHBOARD.baseRoute) },
        )
        dashBoardGraph(
            { navController.navigateToCurrentWeather() },
            onNavigateToForecast = { navController.navigateToForecast() },
        )
    }
}