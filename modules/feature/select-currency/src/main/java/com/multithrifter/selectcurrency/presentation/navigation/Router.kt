package com.multithrifter.selectcurrency.presentation.navigation

import com.multithrifter.core.domain.entity.Currency

internal interface Router {
    fun showSelectCurrencyScreen(currency: Currency? = null)
    fun onBack()
}