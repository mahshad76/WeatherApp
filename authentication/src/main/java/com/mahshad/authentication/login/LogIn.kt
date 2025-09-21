package com.mahshad.authentication.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mahshad.authentication.R
import com.mahshad.systemdesign.BlueBackground
import com.mahshad.systemdesign.Button
import com.mahshad.systemdesign.MatchPatternNote
import com.mahshad.systemdesign.TextField
import com.mahshad.systemdesign.WhiteBackground
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
data class LogInRoute(val username: String = "", val password: String = "")

@Composable
fun LoginScreen(
    logInViewModel: LoginViewModel = hiltViewModel(),
    onNavigateToSignUp: () -> Unit,
    onSuccessfulLogin: () -> Unit
) {
    val uiStateValue by logInViewModel.uiState.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BlueBackground("Welcome")
        WhiteBackground({
            Scaffold(
                snackbarHost = { SnackbarHost(hostState = snackBarHostState) }
            )
            { innerPadding ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    TextField(
                        text = uiStateValue.username,
                        update = {
                            logInViewModel.updateUsernameState(it)
                        },
                        placeholder = "example@example.com",
                        keyboardType = KeyboardType.Email,
                        matchPatternError = uiStateValue.usernamePatternError
                    )
                    MatchPatternNote(
                        stringResource(R.string.username_limitations)
                    )
                    TextField(
                        text = uiStateValue.password,
                        update = {
                            logInViewModel.updatePasswordState(it)
                        },
                        placeholder = "••••••••",
                        keyboardType = KeyboardType.Password,
                        matchPatternError = uiStateValue.passwordPatternError
                    )
                    MatchPatternNote(
                        stringResource(R.string.password_limitations)
                    )
                    Button(
                        onClick = {
                            logInViewModel.onClick()
                            if (logInViewModel.uiState.value.successful) {
                                coroutineScope.launch {
                                    logInViewModel.loginUser()
                                }

                            } else {

                            }
                        },
                        name = "Log In",
                        buttonColor = Color(0xFF00B1D0),
                        contentColor = Color.White,
                        enabled = uiStateValue.activeButton
                    )
                    Button(
                        onClick = {
                            onNavigateToSignUp.invoke()
                        },
                        name = "Sign Up",
                        buttonColor = Color(0xFFDFF7E2),
                        contentColor = Color.Black,
                        enabled = true
                    )

                    LaunchedEffect(uiStateValue.loginError) {
                        val errorMessage = uiStateValue.loginError
                        if (errorMessage != null) {
                            coroutineScope.launch {
                                val result = snackBarHostState.showSnackbar(
                                    message = errorMessage,
                                    actionLabel = "Dismiss"
                                )
                            }
                            logInViewModel.onSnackBarDismissed()
                        }
                    }
                }
            }
        })
    }
}
