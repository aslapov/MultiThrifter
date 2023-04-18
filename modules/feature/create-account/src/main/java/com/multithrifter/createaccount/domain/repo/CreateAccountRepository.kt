package com.multithrifter.createaccount.domain.repo

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency
import kotlinx.coroutines.flow.StateFlow

internal interface CreateAccountRepository {
    suspend fun createAccount(account: Account)
    fun updateSelectedCurrency(currency: Currency)
    val selectedCurrency: StateFlow<Currency>
}