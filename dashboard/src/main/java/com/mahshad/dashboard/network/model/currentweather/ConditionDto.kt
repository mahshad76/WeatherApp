package com.mahshad.network.models

import com.mahshad.dashboard.repository.model.Condition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConditionDto(
    @SerialName("text") var text: String? = null,
    @SerialName("icon") var icon: String? = null,
    @SerialName("code") var code: Int? = null
)

fun ConditionDto.toCondition(): Condition =
    Condition(
        text = text ?: "",
        icon = icon ?: "",
        code = code ?: 0
    )
