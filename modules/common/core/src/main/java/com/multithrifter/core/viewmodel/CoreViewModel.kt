package com.multithrifter.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class CoreViewModel<S : UiState, E : UiEvent> : ViewModel() {

    private val initialState: S by lazy { createInitialState() }

    private val _uiState: MutableStateFlow<S> = MutableStateFlow(initialState)
    val uiState = _uiState.asStateFlow()

    val currentState: S
        get() = uiState.value

    private val event: MutableSharedFlow<E> = MutableSharedFlow()

    init {
        subscribeEvents()
    }

    abstract fun createInitialState() : S

    abstract fun handleEvent(event: E)

    fun setEvent(event: E) {
        viewModelScope.launch { this@CoreViewModel.event.emit(event) }
    }

    fun setState(block: S.() -> S) {
        _uiState.value = currentState.block()
    }

    private fun subscribeEvents() {
        viewModelScope.launch {
            event.collect {
                handleEvent(it)
            }
        }
    }
}