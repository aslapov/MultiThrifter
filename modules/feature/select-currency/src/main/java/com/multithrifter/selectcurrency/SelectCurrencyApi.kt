package com.multithrifter.selectcurrency

import com.multithrifter.core.domain.entity.Currency

interface SelectCurrencyApi {
    fun showSelectCurrencyScreen(currency: Currency? = null)
}