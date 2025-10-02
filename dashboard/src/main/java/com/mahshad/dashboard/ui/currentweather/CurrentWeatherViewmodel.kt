package com.mahshad.dashboard.ui.currentweather

import androidx.lifecycle.ViewModel
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.mahshad.network.models.currentweather.CurrentWeatherDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewmodel @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig
) :
    ViewModel() {
    private val _currentWeather: MutableStateFlow<Response> =
        MutableStateFlow(Response.Loading)
    val currentWeather: StateFlow<Response> = _currentWeather

    init {
        getDataFromFirebaseRemoteConfig()
    }

    private fun getDataFromFirebaseRemoteConfig() {
        firebaseRemoteConfig
            .fetchAndActivate()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val propertyValue = firebaseRemoteConfig.getString("weather")
                    _currentWeather.value = Response.Loading
                    try {
                        val configData = Json.decodeFromString<CurrentWeatherDto>(propertyValue)
                        _currentWeather.value = Response.Success(configData)

                    } catch (e: Exception) {
                        _currentWeather.value = Response.Error(e.message.toString())
                    }
                } else {
                    _currentWeather.value = Response.Error("unsuccessful fetch or activation")
                }
            }
    }
}

sealed interface Response {
    data class Success(val response: CurrentWeatherDto) : Response
    data class Error(val e: String) : Response
    data object Loading : Response
}