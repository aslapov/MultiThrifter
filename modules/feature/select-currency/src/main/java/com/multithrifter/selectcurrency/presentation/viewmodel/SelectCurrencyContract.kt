package com.multithrifter.selectcurrency.presentation.viewmodel

import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.viewmodel.UiEvent
import com.multithrifter.core.viewmodel.UiState

internal object SelectCurrencyContract {

    data class SelectCurrencyState(
        val selectedCurrency: Currency? = null,
        val currencies: List<Currency> = emptyList(),
    ) : UiState

    sealed class SelectCurrencyEvent : UiEvent {
        object BackClicked : SelectCurrencyEvent()
        data class Initialize(val currency: Currency) : SelectCurrencyEvent()
        data class CurrencySelected(val currency: Currency) : SelectCurrencyEvent()
    }
}