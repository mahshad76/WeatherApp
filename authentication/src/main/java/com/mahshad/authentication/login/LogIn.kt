package com.mahshad.authentication.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object LogInRoute

fun NavGraphBuilder.loginNavGraph(
    onNavigateToSignUp: () -> Unit,
    onSuccessLogIn: () -> Unit
) {
    composable<LogInRoute> {
        LoginScreen(
//            onNavigateToSignUp = onNavigateToSignUp,
//            onSuccessLogIn = onSuccessLogIn
        )
    }
}




@Composable
fun LoginScreen(
    //o/nSuccess: () -> Unit
) {
    Text(
        text = "Welcome to a styled text example!"
    )

}
