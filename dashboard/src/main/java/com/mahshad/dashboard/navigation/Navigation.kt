package com.mahshad.dashboard.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mahshad.dashboard.ui.currentweather.CurrentWeather
import com.mahshad.dashboard.ui.weatherforecast.WeatherForecast
import kotlinx.serialization.Serializable

@Serializable
data object DashBoardRoute

fun NavGraphBuilder.dashBoardGraph(
    onNavigateToCurrentWeather: () -> Unit,
    onNavigateToForecast: () -> Unit
) {
    navigation<DashBoardRoute>(
        startDestination = CurrentWeather
    ) {
        composable<CurrentWeather> {
            CurrentWeather(onNavigateToForecast)
        }
        composable<WeatherForecast> {
            WeatherForecast(onNavigateToCurrentWeather)
        }
    }
}

fun NavHostController.navigateToForecast() = navigate(WeatherForecast)

fun NavHostController.navigateToCurrentWeather() = navigate(CurrentWeather)
