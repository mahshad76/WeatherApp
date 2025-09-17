package com.mahshad.authentication.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

data class SignUpState(
    val username: String,
    val password: String,
    val passwordIsVisible: Boolean,
    val isSignUpButtonEnabled: Boolean = false,
    val isPasswordValid: Boolean = true,
    val isUsernameValid: Boolean = true,
    val isSignUpSuccessful: Boolean = false
)

@HiltViewModel
class SignUpViewModel @Inject constructor(private val auth: FirebaseAuth) : ViewModel() {
    private val _uiState: MutableStateFlow<SignUpState> = MutableStateFlow(
        SignUpState(
            "",
            "",
            false
        )
    )
    val uiState: StateFlow<SignUpState> = _uiState

    fun updateUsernameState(username: String) {
        _uiState.update { stateValue ->
            stateValue.copy(
                username = username,
                isSignUpButtonEnabled = !stateValue.password.isEmpty() && !username.isEmpty(),
                isUsernameValid = !username.isEmpty()
            )
        }
    }

    fun updatePasswordState(password: String) {
        _uiState.update { stateValue ->
            stateValue.copy(
                password = password,
                isSignUpButtonEnabled = !stateValue.username.isEmpty() && !password.isEmpty(),
                isPasswordValid = !password.isEmpty()
            )
        }
    }

    fun updatePasswordVisibilityState(isVisible: Boolean) {
        _uiState.update { stateValue -> stateValue.copy(passwordIsVisible = isVisible) }
    }

    fun signUp(username: String, password: String) {
        if (uiState.value.isSignUpButtonEnabled) {
            viewModelScope.launch {
                val authResult = createFirebaseUser(email = username, password = password)
                _uiState.update { stateValue ->
                    stateValue.copy(isSignUpSuccessful = authResult.user != null)
                }
            }
        }
    }

    private suspend fun createFirebaseUser(email: String, password: String): AuthResult =
        suspendCancellableCoroutine { continuation ->
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        continuation.resume(task.result!!)
                    } else {
                        continuation.resumeWithException(task.exception!!)
                    }
                }

            continuation.invokeOnCancellation {
                // Cleanup
            }
        }
}