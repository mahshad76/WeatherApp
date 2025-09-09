package com.mahshad.authentication.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class LoginState(
    val username: String,
    val password: String
)

class LoginViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<LoginState> = MutableStateFlow(
        LoginState(
            "",
            ""
        )
    )
    val uiState: StateFlow<LoginState> = _uiState

    fun updateUsernameState(username: String) {
        _uiState.update { stateValue -> stateValue.copy(username = username) }
    }

    fun updatePasswordState(password: String) {
        _uiState.update { stateValue -> stateValue.copy(password = password) }
    }
}