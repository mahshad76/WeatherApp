package com.mahshad.authentication.signup

import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.mahshad.authentication.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

@HiltViewModel
class SignUpViewModel @Inject constructor(private val auth: FirebaseAuth) : BaseViewModel() {

    fun signingUp() {
        viewModelScope.launch {
            createFirebaseUser(
                email = uiState.value.username,
                password = uiState.value.password
            )
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