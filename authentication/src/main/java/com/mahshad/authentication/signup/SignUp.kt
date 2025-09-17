package com.mahshad.authentication.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
data object SignUpRoute

@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = hiltViewModel(),
    onNavigateToLogIn: (String, String) -> Unit
) {
    val uiStateValue by signUpViewModel.uiState.collectAsStateWithLifecycle()
    if (uiStateValue.isSignUpSuccessful) {
        onNavigateToLogIn(uiStateValue.username, uiStateValue.password)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BlueBackground("Create an account")
        WhiteBackground({
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    uiStateValue.username,
                    { signUpViewModel.updateUsernameState(it) })
                PasswordTextField(
                    uiStateValue.password,
                    uiStateValue.passwordIsVisible,
                    { signUpViewModel.updatePasswordState(it) },
                    {
                        signUpViewModel.updatePasswordVisibilityState(it)
                    }
                )
                Button(
                    onClick = {
                        signUpViewModel.signUp(
                            uiStateValue.username,
                            uiStateValue.password
                        )
                    },
                    name = "Sign Up",
                    buttonColor = Color(0xFF00B1D0),
                    contentColor = Color.White,
                    enabled = uiStateValue.isSignUpButtonEnabled
                )
            }
        })
    }
}