package com.mahshad.dashboard.ui.weatherforecast

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data object WeatherForecast

@Composable
fun WeatherForecast() {
    Text("weather forecast")
}