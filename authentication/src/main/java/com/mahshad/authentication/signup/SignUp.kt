package com.mahshad.authentication.signup

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object SignUpRoute


fun NavGraphBuilder.signUpNavGraph(
    onNavigateToLogIn: () -> Unit
) {
    composable<SignUpRoute>{
        SignUpScreen(
            onNavigateToLogIn = onNavigateToLogIn
        )
    }
}

@Composable
fun SignUpScreen(onNavigateToLogIn: () -> Unit) {

}
