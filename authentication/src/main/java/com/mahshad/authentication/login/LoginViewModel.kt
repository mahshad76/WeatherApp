package com.mahshad.authentication.login

import com.mahshad.authentication.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

data class LoginState(
    val username: String,
    val password: String,
    val activeLoginButton: Boolean,
    val usernamePatternError: Boolean,
    val passwordPatternError: Boolean
)

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel() {
    init {
        ///collecting of the stream to see if the successful action has happened
    }
    private fun firebaseLogin() {}
}