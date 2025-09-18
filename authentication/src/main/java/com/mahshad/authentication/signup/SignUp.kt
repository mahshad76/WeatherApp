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
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mahshad.authentication.design.BlueBackground
import com.mahshad.authentication.design.Button
import com.mahshad.authentication.design.TextField
import com.mahshad.authentication.design.WhiteBackground
import kotlinx.serialization.Serializable

@Serializable
data object SignUpRoute

@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = hiltViewModel(),
    onNavigateToLogIn: (String, String) -> Unit
) {
    val uiStateValue by signUpViewModel.uiState.collectAsStateWithLifecycle()

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
                    text = uiStateValue.username,
                    update = {
                        signUpViewModel.updateUsernameState(it)
                    },
                    placeholder = "example@example.com",
                    keyboardType = KeyboardType.Email,
                    matchPatternError = uiStateValue.usernamePatternError
                )
                TextField(
                    text = uiStateValue.password,
                    update = {
                        signUpViewModel.updatePasswordState(it)
                    },
                    placeholder = "••••••••",
                    keyboardType = KeyboardType.Password,
                    matchPatternError = uiStateValue.passwordPatternError
                )
                Button(
                    onClick = {
                        signUpViewModel.onClick()
                        if (uiStateValue.successful) {
                            signUpViewModel.signingUp()
                            onNavigateToLogIn(uiStateValue.username, uiStateValue.password)
                        } else {

                        }
                    },
                    name = "Sign Up",
                    buttonColor = Color(0xFF00B1D0),
                    contentColor = Color.White,
                    enabled = uiStateValue.activeButton
                )
            }
        })
    }
}