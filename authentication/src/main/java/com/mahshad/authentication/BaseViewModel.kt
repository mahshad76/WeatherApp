package com.mahshad.authentication

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

open class BaseViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow<State>(
        State(
            username = "",
            password = "",
            activeButton = false,
            usernamePatternError = false,
            passwordPatternError = false,
            successful = false,
            loginError = null
        )
    )
    val uiState: StateFlow<State> = _uiState

    fun updateUsernameState(username: String) {
        _uiState.update { stateValue ->
            stateValue.copy(
                username = username,
                usernamePatternError = false,
                activeButton = !stateValue.password.isEmpty()
            )
        }
    }

    fun updatePasswordState(password: String) {
        _uiState.update { stateValue ->
            stateValue.copy(
                password = password,
                passwordPatternError = false,
                activeButton = !stateValue.username.isEmpty()
            )
        }
    }

    fun updateLoginError(error: String) {
        _uiState.update { stateValue ->
            stateValue.copy(loginError = error)
        }
    }

    fun onSnackBarDismissed() {
        _uiState.update { stateValue ->
            stateValue.copy(loginError = null)
        }
    }

    fun onClick() {
        val usernamePattern = ("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]" +
                "+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$").toRegex()
        val passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$".toRegex()
        val isUsernameValid = usernamePattern.matches(_uiState.value.username)
        val isPasswordValid = passwordPattern.matches(_uiState.value.password)

        if (isUsernameValid && isPasswordValid) {
            _uiState.update { stateValue ->
                stateValue.copy(successful = true)
            }
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
}

data class State(
    val username: String,
    val password: String,
    val activeButton: Boolean,
    val usernamePatternError: Boolean,
    val passwordPatternError: Boolean,
    val successful: Boolean,
    val loginError: String?
)