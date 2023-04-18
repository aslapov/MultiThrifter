package com.multithrifter.createaccount.presentation.navigation

import com.multithrifter.core.domain.entity.Currency

internal interface Router {
    fun showCreateAccountScreen()
    fun showCurrenciesScreen(selectedCurrency: Currency? = null)
    fun onBack()
}