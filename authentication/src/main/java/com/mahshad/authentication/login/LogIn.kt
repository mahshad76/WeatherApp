package com.mahshad.authentication.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mahshad.authentication.components.BlueBackground
import com.mahshad.authentication.components.Button
import com.mahshad.authentication.components.PasswordTextField
import com.mahshad.authentication.components.TextField
import com.mahshad.authentication.components.WhiteBackground
import kotlinx.serialization.Serializable

@Serializable
data class LogInRoute(val username: String = "", val password: String = "")

@Composable
fun LoginScreen(
    logInViewModel: LoginViewModel = hiltViewModel(),
    onNavigateToSignUp: () -> Unit
) {
    val uiStateValue by logInViewModel.uiState.collectAsStateWithLifecycle()
    Text(
        text = "Welcome"
    )
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BlueBackground()
        WhiteBackground({
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    uiStateValue.username,
                    { logInViewModel.updateUsernameState(it) })
                PasswordTextField(
                    uiStateValue.password,
                    uiStateValue.passwordIsVisible,
                    { logInViewModel.updatePasswordState(it) },
                    { logInViewModel.updatePasswordVisibilityState(it) }
                )
                Button(
                    onClick = {},
                    name = "Log In",
                    buttonColor = Color(0xFF00B1D0),
                    contentColor = Color.White
                )
                Button(
                    onClick = { onNavigateToSignUp.invoke() },
                    name = "Sign Up",
                    buttonColor = Color(0xFFDFF7E2),
                    contentColor = Color.Black
                )
            }
        })
    }
}
