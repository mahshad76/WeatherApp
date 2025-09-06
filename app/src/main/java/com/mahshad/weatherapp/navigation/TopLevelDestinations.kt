package com.mahshad.weatherapp.navigation

import com.mahshad.authentication.navigation.AuthRoute
import kotlin.reflect.KClass

enum class TopLevelDestinations(val baseRoute: KClass<*>) {
    AUTH(AuthRoute::class)
}