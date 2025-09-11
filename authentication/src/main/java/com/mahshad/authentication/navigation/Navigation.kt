package com.mahshad.authentication.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.mahshad.authentication.login.LogInRoute
import com.mahshad.authentication.login.LoginScreen
import com.mahshad.authentication.signup.SignUpRoute
import com.mahshad.authentication.signup.SignUpScreen
import kotlinx.serialization.Serializable

@Serializable
data object AuthRoute

val NavController.onNavigateToLogIn: (username: String, password: String) -> Unit
    get() = { username, password ->
        this.navigate(LogInRoute(username, password))
    }

val NavController.onNavigateToSignUp: () -> Unit
    get() = { this.navigate(SignUpRoute) }

val NavController.onSuccessLogIn: () -> Unit
    get() = { }

fun NavGraphBuilder.authNavGraph(
    onNavigateToSignUp: () -> Unit,
    onNavigateToLogIn: (String, String) -> Unit,
    onSuccessLogIn: () -> Unit
) {
    navigation<AuthRoute>(startDestination = LogInRoute::class) {
        composable<LogInRoute> {
            LoginScreen(onNavigateToSignUp = onNavigateToSignUp)
        }
        composable<SignUpRoute> {
            SignUpScreen(onNavigateToLogIn = onNavigateToLogIn)
        }
    }
}
