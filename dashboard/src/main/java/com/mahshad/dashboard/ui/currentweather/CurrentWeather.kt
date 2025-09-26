package com.mahshad.dashboard.ui.currentweather

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data object CurrentWeather

@Composable
fun CurrentWeather(viewmodel: CurrentWeatherViewmodel) {
    Text("current weather")
}