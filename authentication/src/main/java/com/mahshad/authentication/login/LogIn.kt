package com.mahshad.authentication.login

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data object LogInRoute

@Composable
fun LoginScreen(
    onNavigateToSignUp: () -> Unit
) {
    Text(
        text = "Welcome to a styled text example!"
    )
}
