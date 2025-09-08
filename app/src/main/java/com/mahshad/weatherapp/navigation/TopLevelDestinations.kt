package com.mahshad.weatherapp.navigation

import com.mahshad.authentication.navigation.AuthRoute
import com.mahshad.authentication.navigation.MainRoute
import kotlin.reflect.KClass

enum class TopLevelDestinations(val baseRoute: KClass<*>) {
    AUTH(AuthRoute::class),
    MAIN(MainRoute::class)
}