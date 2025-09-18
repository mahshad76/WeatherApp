package com.mahshad.authentication.login

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.mahshad.authentication.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.tasks.await

data class LoginState(
    val username: String,
    val password: String,
    val activeLoginButton: Boolean,
    val usernamePatternError: Boolean,
    val passwordPatternError: Boolean
)

@HiltViewModel
class LoginViewModel @Inject constructor(private val auth: FirebaseAuth) : BaseViewModel() {
    init {
        ///collecting of the stream to see if the successful action has happened
    }

    suspend fun loginUser() {
        // This coroutine will handle the Firebase async call
        // and convert it into a suspend function.
        val email = uiState.value.username
        val password = uiState.value.password
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            Log.d("TAG", "signInWithEmail:success")
            // No UI logic here, just return success
        } catch (e: Exception) {
            // Handle login failure
            Log.w("TAG", "signInWithEmail:failure", e)
            throw e // Re-throw the exception to be handled by the caller
        }
    }
}