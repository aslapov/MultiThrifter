package com.multithrifter.selectcurrency.domain.interactor

import com.multithrifter.core.domain.entity.Currency

internal interface SelectCurrencyInteractor {

    suspend fun getCurrencies(): List<Currency>
}