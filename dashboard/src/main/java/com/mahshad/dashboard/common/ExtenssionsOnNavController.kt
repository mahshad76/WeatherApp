package com.mahshad.dashboard.common

import androidx.navigation.NavHostController
import com.mahshad.dashboard.ui.currentweather.CurrentWeather
import com.mahshad.dashboard.ui.weatherforecast.WeatherForecast

fun NavHostController.navigateToForecast() = navigate(WeatherForecast)

fun NavHostController.navigateToCurrentWeather() = navigate(CurrentWeather)