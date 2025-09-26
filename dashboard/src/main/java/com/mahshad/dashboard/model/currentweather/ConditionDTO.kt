package com.mahshad.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Condition(
    @SerialName("text") var text: String? = null,
    @SerialName("icon") var icon: String? = null,
    @SerialName("code") var code: Int? = null
)