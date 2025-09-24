package com.mahshad.authentication.navigation

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

fun NavGraphBuilder.authNavGraph(
    onNavigateToSignUp: () -> Unit,
    onNavigateToLogIn: (String, String) -> Unit,
    onSuccessLogIn: () -> Unit
) {
    navigation<AuthRoute>(startDestination = LogInRoute::class) {
        composable<LogInRoute> {
            LoginScreen(
                onNavigateToSignUp = onNavigateToSignUp,
                onSuccessfulLogin = onSuccessLogIn
            )
        }
        composable<SignUpRoute> {
            SignUpScreen(onNavigateToLogIn = onNavigateToLogIn)
        }
    }
}
