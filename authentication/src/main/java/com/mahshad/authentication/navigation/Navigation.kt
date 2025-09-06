package com.mahshad.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.mahshad.authentication.login.LogInRoute
import com.mahshad.authentication.signup.SignUpRoute
import kotlinx.serialization.Serializable

@Serializable
data object AuthRoute

val NavController.onNavigateToLogIn: (String, String) -> Unit
    get() = { email, password ->
        this.navigate(LogInRoute(email, password))
    }

val NavController.onNavigateToSignUp: () -> Unit
    get() = { this.navigate(SignUpRoute) }

val NavController.onSuccessLogIn: () -> Unit
    get() = { this.navigate("") }

fun NavGraphBuilder.authNavGraph(
    onNavigateToSignUp: () -> Unit,
    onNavigateToLogIn: (String, String) -> Unit,
    onSuccessLogIn: () -> Unit
) {
    ///defining the composables or navigation if you want to define another sub navigation graph

}
