package com.mahshad.network.models.currentweather

import com.mahshad.dashboard.repository.model.CurrentWeather
import com.mahshad.network.models.LocationDto
import com.mahshad.network.models.toLocation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDto(
    @SerialName("location") var locationDto: LocationDto? = LocationDto(),
    @SerialName("current") var currentDto: CurrentDto? = CurrentDto()
)

fun CurrentWeatherDto.toCurrentWeather(): Result<CurrentWeather> =
    runCatching {
        val currentDtoNonNull = currentDto
            ?: throw IllegalArgumentException("CurrentDTO is missing for CurrentWeather and cannot be null.")
        val locationDtoNonNull = locationDto
            ?: throw IllegalArgumentException("LocationDTO is missing for CurrentWeather and cannot be null.")
        val current = currentDtoNonNull.toCurrent().getOrThrow()
        val location = locationDtoNonNull.toLocation()
        CurrentWeather(location, current)
    }