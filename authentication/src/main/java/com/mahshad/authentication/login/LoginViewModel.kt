package com.mahshad.authentication.login

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.mahshad.authentication.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.tasks.await

@HiltViewModel
class LoginViewModel @Inject constructor(private val auth: FirebaseAuth) : BaseViewModel() {
    suspend fun loginUser() {
        val email = uiState.value.username
        val password = uiState.value.password
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            Log.d("TAG", "signInWithEmail:success")
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
}