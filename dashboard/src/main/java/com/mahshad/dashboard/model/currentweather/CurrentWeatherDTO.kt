package com.mahshad.network.models.currentweather

import com.mahshad.network.models.Location
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDTO(
    @SerialName("location") var location: Location? = Location(),
    @SerialName("current") var current: Current? = Current()
)