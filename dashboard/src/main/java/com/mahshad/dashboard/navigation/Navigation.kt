package com.mahshad.dashboard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mahshad.dashboard.ui.currentweather.CurrentWeather
import com.mahshad.dashboard.ui.weatherforecast.WeatherForecast
import kotlinx.serialization.Serializable

@Serializable
data object DashBoardRoute

fun NavGraphBuilder.dashBoardGraph() {
    navigation<DashBoardRoute>(
        startDestination = CurrentWeather
    ) {
        composable<CurrentWeather> { }
        composable<WeatherForecast> { }
    }
}

fun NavController.navigateFromCurrentToForecast() {

}

fun NavController.navigateFromForecastToWeather() {

}
