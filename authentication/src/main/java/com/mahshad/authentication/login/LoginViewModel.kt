package com.mahshad.authentication.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class LoginState(
    val username: String,
    val password: String,
    val activeLoginButton: Boolean,
    val usernamePatternError: Boolean,
    val passwordPatternError: Boolean
)

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _uiState: MutableStateFlow<LoginState> = MutableStateFlow(
        LoginState(
            username = "",
            password = "",
            activeLoginButton = false,
            usernamePatternError = false,
            passwordPatternError = false
        )
    )
    val uiState: StateFlow<LoginState> = _uiState

    fun updateUsernameState(username: String) {
        _uiState.update { stateValue ->
            stateValue.copy(
                username = username,
                usernamePatternError = false,
                activeLoginButton = !stateValue.password.isEmpty()
            )
        }
    }

    fun updatePasswordState(password: String) {
        _uiState.update { stateValue ->
            stateValue.copy(
                password = password,
                passwordPatternError = false,
                activeLoginButton = !stateValue.username.isEmpty()
            )
        }
    }

    ///onclick of the login button must have two steps, one checking the match pattern ,
// if it is successful, calling the firebase re3lative method.
    fun onLoginClick() {
        val usernamePattern = ("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]" +
                "+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$").toRegex()
        val passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$".toRegex()
        val isUsernameValid = usernamePattern.matches(_uiState.value.username)
        val isPasswordValid = passwordPattern.matches(_uiState.value.password)

        if (isUsernameValid && isPasswordValid) {
            // Both fields are valid, proceed with login
            // ... (e.g., call a login API)
            // hide any error messages
        } else {
            if (!isUsernameValid) {
                _uiState.update { stateValue ->
                    stateValue.copy(usernamePatternError = true)
                }
            }

            if (!isPasswordValid) {
                _uiState.update { stateValue ->
                    stateValue.copy(passwordPatternError = true)
                }
            }
        }
    }

    private fun firebaseLogin() {}

}