package com.mahshad.dashboard.ui.currentweather

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.mahshad.network.models.currentweather.CurrentWeatherDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewmodel @Inject constructor(
    private val firebaseRemoteConfig: FirebaseRemoteConfig
) :
    ViewModel() {
    init {
        firebaseRemoteConfig
            .fetchAndActivate()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val propertyValue = firebaseRemoteConfig.getString("weather")
                    Log.d("TAG", "${propertyValue}")
                    try {
                        val configData = Json.decodeFromString<CurrentWeatherDTO>(propertyValue)

                        // Now you can use configData:
                        Log.d("TAG", "Feature toggle is: ${configData.location?.name}")

                    } catch (e: Exception) {
                        Log.e("TAG", "error in serializing")
                    }
                } else {
                    Log.i("TAG", "unsuccessful fetch or activation")
                }
            }
    }
}