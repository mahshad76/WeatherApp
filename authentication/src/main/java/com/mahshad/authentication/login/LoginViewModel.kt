package com.mahshad.authentication.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class LoginState(
    val username: String,
    val password: String,
    val passwordIsVisible: Boolean,
    val activeLoginButton: Boolean,
    val usernameError: Boolean,
    val passwordError: Boolean
)

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val username: String = savedStateHandle["username"] ?: ""
    val password: String = savedStateHandle["password"] ?: ""
    private val _uiState: MutableStateFlow<LoginState> = MutableStateFlow(
        LoginState(
            username,
            password,
            false,
            false,
            false,
            false
        )
    )
    val uiState: StateFlow<LoginState> = _uiState

    fun updateUsernameState(username: String) {
        _uiState.update { stateValue -> stateValue.copy(username = username) }
    }

    fun updatePasswordState(password: String) {
        _uiState.update { stateValue -> stateValue.copy(password = password) }
    }

    fun updatePasswordVisibilityState() {
        _uiState.update { stateValue ->
            stateValue.copy(passwordIsVisible = !stateValue.passwordIsVisible)
        }
    }

    fun validateUsername() {
        _uiState.update { stateValue ->
            stateValue.copy(
                usernameError = stateValue.username.matches("\\d{4}".toRegex()),
                activeLoginButton = stateValue.usernameError && stateValue.passwordError
            )
        }
    }

    fun validatePassword() {
        _uiState.update { stateValue ->
            stateValue.copy(
                passwordError = stateValue.password.matches("\\d{4}".toRegex()),
                activeLoginButton = stateValue.usernameError && stateValue.passwordError
            )
        }
    }
}