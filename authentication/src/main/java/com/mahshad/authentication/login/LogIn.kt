package com.mahshad.authentication.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mahshad.authentication.components.BlueBackground
import com.mahshad.authentication.components.WhiteBackground
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
    Box(Modifier.fillMaxSize()) {
        BlueBackground()
        WhiteBackground({})
    }
}

@Preview
@Composable
fun View() {
    LoginScreen({})
}
