package com.mahshad.authentication.common

import androidx.navigation.NavController
import com.mahshad.authentication.login.LogInRoute
import com.mahshad.authentication.signup.SignUpRoute

val NavController.onNavigateToLogIn: (username: String, password: String) -> Unit
    get() = { username, password ->
        this.navigate(LogInRoute(username, password))
    }

val NavController.onNavigateToSignUp: () -> Unit
    get() = { this.navigate(SignUpRoute) }