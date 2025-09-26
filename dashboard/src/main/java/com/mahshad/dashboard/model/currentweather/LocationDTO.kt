package com.mahshad.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("name") var name: String? = null,
    @SerialName("region") var region: String? = null,
    @SerialName("country") var country: String? = null,
    @SerialName("lat") var lat: Double? = null,
    @SerialName("lon") var lon: Double? = null,
    @SerialName("tz_id") var tzId: String? = null,
    @SerialName("localtime_epoch") var localtimeEpoch: Int? = null,
    @SerialName("localtime") var localtime: String? = null
)