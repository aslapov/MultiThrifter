package com.multithrifter.selectcurrency.domain.repo

import com.multithrifter.core.domain.entity.Currency

internal interface SelectCurrencyRepository {
    suspend fun getCurrencies(): List<Currency>
}