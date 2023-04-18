package com.multithrifter.editaccount.presentation.navigation

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency
import kotlinx.coroutines.flow.MutableSharedFlow

internal interface Router {

    fun showEditAccountScreen(account: Account)

    fun showCurrenciesScreen(
        selectedCurrencyListener: MutableSharedFlow<Currency>,
        currency: Currency? = null,
    )

    fun onBack()
}