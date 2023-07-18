package com.anandj.rickmorty.framework

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<StateT, in ActionT>(initialState: StateT) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<StateT> = _state

    protected fun setState(state: StateT) {
        _state.value = state
    }

    fun sendAction(action: ActionT) {
        viewModelScope.launch {
            onAction(action)
        }
    }

    abstract suspend fun onAction(action: ActionT)
}
