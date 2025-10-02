package com.mahshad.network.models.currentweather

import com.mahshad.dashboard.repository.model.Current
import com.mahshad.network.models.ConditionDto
import com.mahshad.network.models.toCondition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentDto(
    @SerialName("last_updated_epoch") var lastUpdatedEpoch: Int? = null,
    @SerialName("last_updated") var lastUpdated: String? = null,
    @SerialName("temp_c") var tempC: Double? = null,
    @SerialName("temp_f") var tempF: Double? = null,
    @SerialName("is_day") var isDay: Int? = null,
    @SerialName("condition") var conditionDto: ConditionDto? = ConditionDto(),
    @SerialName("wind_mph") var windMph: Double? = null,
    @SerialName("wind_kph") var windKph: Double? = null,
    @SerialName("wind_degree") var windDegree: Int? = null,
    @SerialName("wind_dir") var windDir: String? = null,
    @SerialName("pressure_mb") var pressureMb: Double? = null,
    @SerialName("pressure_in") var pressureIn: Double? = null,
    @SerialName("precip_mm") var precipMm: Double? = null,
    @SerialName("precip_in") var precipIn: Double? = null,
    @SerialName("humidity") var humidity: Int? = null,
    @SerialName("cloud") var cloud: Int? = null,
    @SerialName("feelslike_c") var feelslikeC: Double? = null,
    @SerialName("feelslike_f") var feelslikeF: Double? = null,
    @SerialName("windchill_c") var windchillC: Double? = null,
    @SerialName("windchill_f") var windchillF: Double? = null,
    @SerialName("heatindex_c") var heatindexC: Double? = null,
    @SerialName("heatindex_f") var heatindexF: Double? = null,
    @SerialName("dewpoint_c") var dewpointC: Double? = null,
    @SerialName("dewpoint_f") var dewpointF: Double? = null,
    @SerialName("vis_km") var visKm: Double? = null,
    @SerialName("vis_miles") var visMiles: Double? = null,
    @SerialName("uv") var uv: Double? = null,
    @SerialName("gust_mph") var gustMph: Double? = null,
    @SerialName("gust_kph") var gustKph: Double? = null,
    @SerialName("short_rad") var shortRad: Double? = null,
    @SerialName("diff_rad") var diffRad: Double? = null,
    @SerialName("dni") var dni: Double? = null,
    @SerialName("gti") var gti: Double? = null
)

fun CurrentDto.toCurrent(): Result<Current> =
    runCatching {
        val requiredConditionDTO = conditionDto?.toCondition()
            ?: throw IllegalArgumentException("Condition data is mandatory for Current and cannot be null.")
        Current(
            cloud = cloud ?: 0,
            humidity = humidity ?: 0,
            isDay = isDay ?: 0,
            precipIn = precipIn ?: 0.0,
            precipMm = precipMm ?: 0.0,
            pressureIn = pressureIn ?: 0.0,
            pressureMb = pressureMb ?: 0.0,
            uv = uv ?: 0.0,
            windDegree = windDegree ?: 0,
            windDir = windDir.orEmpty(),
            windKph = windKph ?: 0.0,
            windMph = windMph ?: 0.0,
            windchillC = windchillC ?: 0.0,
            windchillF = windchillF ?: 0.0,
            lastUpdatedEpoch = lastUpdatedEpoch ?: 0,
            lastUpdated = lastUpdated ?: "",
            tempC = tempC ?: 0.0,
            tempF = tempF ?: 0.0,
            condition = requiredConditionDTO,
            feelslikeC = feelslikeC ?: 0.0,
            feelslikeF = feelslikeF ?: 0.0,
            heatindexC = heatindexC ?: 0.0,
            heatindexF = heatindexF ?: 0.0,
            dewpointC = dewpointC ?: 0.0,
            dewpointF = dewpointF ?: 0.0,
            visKm = visKm ?: 0.0,
            visMiles = visKm ?: 0.0,
            gustMph = gustMph ?: 0.0,
            gustKph = gustKph ?: 0.0,
            shortRad = shortRad ?: 0.0,
            diffRad = diffRad ?: 0.0,
            dni = dni ?: 0.0,
            gti = gti ?: 0.0,
        )
    }

