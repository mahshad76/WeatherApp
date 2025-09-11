package com.mahshad.authentication.signup

import androidx.lifecycle.ViewModel
import com.mahshad.authentication.login.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class SignUpState(
    val username: String,
    val password: String,
    val passwordIsVisible: Boolean
)

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {
    private val _uiState: MutableStateFlow<LoginState> = MutableStateFlow(
        LoginState(
            "",
            "",
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