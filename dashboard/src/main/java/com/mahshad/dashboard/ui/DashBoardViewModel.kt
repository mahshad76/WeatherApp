package com.mahshad.dashboard.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class DashBoardViewModel @Inject constructor() : ViewModel() {
    private val _uiStateFlow = MutableStateFlow<Int>(0)
    val uiStateFlow: StateFlow<Int> = _uiStateFlow

    fun updateSelectedItem(item: Int) {
        _uiStateFlow.update { item }
    }
}