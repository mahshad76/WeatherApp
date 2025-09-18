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
    val activeLoginButton: Boolean
)

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    private val _uiState: MutableStateFlow<LoginState> = MutableStateFlow(
        LoginState(
            username = "",
            password = "",
            activeLoginButton = false
        )
    )
    val uiState: StateFlow<LoginState> = _uiState

    fun updateUsernameState(username: String) {
        _uiState.update { stateValue ->
            stateValue.copy(
                username = username,
                activeLoginButton = !stateValue.password.isEmpty()
            )
        }
    }

    fun updatePasswordState(password: String) {
        _uiState.update { stateValue ->
            stateValue.copy(
                password = password,
                activeLoginButton = !stateValue.username.isEmpty()
            )
        }
    }
}