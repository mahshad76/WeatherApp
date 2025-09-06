package com.mahshad.authentication.login

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
data class LogInRoute(
    val email: String,
    val password: String
)

@Composable
fun LogIn(onNavigate: () -> Unit) {

}
