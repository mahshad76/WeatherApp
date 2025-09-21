package com.mahshad.weatherapp.navigation

import com.mahshad.authentication.navigation.AuthRoute
import com.mahshad.dashboard.navigation.DashBoardRoute
import kotlin.reflect.KClass

enum class TopLevelDestinations(val baseRoute: KClass<*>) {
    AUTH(AuthRoute::class),
    DASHBOARD(DashBoardRoute::class)
}