package com.mahshad.dashboard.ui.weatherforecast

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data object WeatherForecast

@Composable
fun WeatherForecast(
    onNavigateToCurrentWeather: () -> Unit
) {

}