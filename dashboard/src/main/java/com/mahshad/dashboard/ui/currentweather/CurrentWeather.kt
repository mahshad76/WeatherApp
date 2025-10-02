package com.mahshad.dashboard.ui.currentweather

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mahshad.systemdesign.WeatherInfoCard

@Composable
fun CurrentWeather(viewModel: CurrentWeatherViewmodel) {

    val currentWeatherState by viewModel.currentWeather.collectAsStateWithLifecycle()

    when (currentWeatherState) {
        is Response.Error -> Text("error")
        Response.Loading -> Text("Loading")
        is Response.Success -> {
            val response = (currentWeatherState as Response.Success).response
            WeatherInfoCard(
                response.locationDto?.country ?: "",
                response.locationDto?.name ?: "",
                response.currentDto?.conditionDto?.text ?: "",
                response.currentDto?.tempC.toString()
            )
        }
    }
}