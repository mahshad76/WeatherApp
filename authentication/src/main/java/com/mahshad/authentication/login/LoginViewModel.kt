package com.mahshad.authentication.login

import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.mahshad.authentication.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

@HiltViewModel
class LoginViewModel @Inject constructor(private val auth: FirebaseAuth) : BaseViewModel() {
    init {
        viewModelScope.launch {
            clickEvent
                .debounce(300)
                .collect {
                    loginUser()
                }
        }
    }
    suspend fun loginUser() {
        onClick()
        val email = uiState.value.username
        val password = uiState.value.password
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            updateLoginSuccess()
        } catch (e: Exception) {
            updateLoginError(e.message.toString())
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

    fun updateLoginSuccess() {
        _uiState.update { stateValue ->
            stateValue.copy(loginSuccess = true)
        }
    }

    fun resetLoginSuccess() {
        _uiState.update { stateValue ->
            stateValue.copy(loginSuccess = false)
        }
    }
}