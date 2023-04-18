package com.multithrifter.createaccount.presentation.navigation

import com.multithrifter.core.domain.entity.Currency
import kotlinx.coroutines.flow.MutableSharedFlow

internal interface Router {
    fun showCreateAccountScreen()
    fun showCurrenciesScreen(
        selectedCurrencyListener: MutableSharedFlow<Currency>,
        currency: Currency? = null,
    )
    fun onBack()
}