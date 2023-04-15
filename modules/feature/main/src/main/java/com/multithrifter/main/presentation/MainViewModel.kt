package com.multithrifter.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.multithrifter.main.domain.interactor.MainInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class MainViewModel @Inject constructor(
    private val interactor: MainInteractor
) : ViewModel() {

    fun updateCurrencyRates() {
        viewModelScope.launch {
            runCatching {
                interactor.updateCurrencyRates()
            }
        }
    }
}