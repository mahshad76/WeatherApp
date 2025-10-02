package com.mahshad.dashboard.navigation

import kotlinx.serialization.Serializable

sealed interface DashboardRoutes {
    @Serializable
    data object CurrentWeather

    @Serializable
    data object WeatherForecast
}