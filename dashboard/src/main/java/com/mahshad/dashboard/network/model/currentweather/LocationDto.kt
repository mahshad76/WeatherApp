package com.mahshad.network.models

import com.mahshad.dashboard.repository.model.Location
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    @SerialName("name") var name: String? = null,
    @SerialName("region") var region: String? = null,
    @SerialName("country") var country: String? = null,
    @SerialName("lat") var lat: Double? = null,
    @SerialName("lon") var lon: Double? = null,
    @SerialName("tz_id") var tzId: String? = null,
    @SerialName("localtime_epoch") var localtimeEpoch: Int? = null,
    @SerialName("localtime") var localtime: String? = null
)

fun LocationDto.toLocation(): Location =
    Location(
        name = name ?: "",
        region = region ?: "",
        country = country ?: "",
        lat = lat ?: 0.0,
        lon = lon ?: 0.0,
        tzId = tzId ?: "",
        localtimeEpoch = localtimeEpoch ?: 0,
        localtime = localtime ?: ""
    )