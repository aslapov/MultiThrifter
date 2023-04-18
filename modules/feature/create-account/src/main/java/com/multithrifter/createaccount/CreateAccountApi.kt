package com.multithrifter.createaccount

import com.multithrifter.core.domain.entity.Currency

interface CreateAccountApi {
    fun showCreateAccountScreen()
    fun updateSelectedCurrency(currency: Currency)
}