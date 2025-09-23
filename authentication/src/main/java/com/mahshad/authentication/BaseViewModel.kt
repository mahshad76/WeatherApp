package com.mahshad.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
open class BaseViewModel() : ViewModel() {
    protected val _uiState = MutableStateFlow<State>(
        State(
            username = "",
            password = "",
            activeButton = false,
            usernamePatternError = false,
            passwordPatternError = false,
            successful = false,
            loginError = null,
            loginSuccess = null
        )
    )
    val uiState: StateFlow<State> = _uiState
    private val _clickEvent: MutableSharedFlow<Unit> = MutableSharedFlow()
    val clickEvent: SharedFlow<Unit> = _clickEvent


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

    fun updateClickEvent() {
        viewModelScope.launch {
            _clickEvent.emit(Unit)
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
    val loginError: String?,
    val loginSuccess: Boolean?
)