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
    val passwordIsVisible: Boolean
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

    fun updatePasswordVisibilityState(isVisible: Boolean) {
        _uiState.update { stateValue -> stateValue.copy(passwordIsVisible = isVisible) }
    }
}