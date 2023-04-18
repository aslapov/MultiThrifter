package com.multithrifter.createaccount.domain.interactor

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency
import kotlinx.coroutines.flow.StateFlow

internal interface CreateAccountInteractor {
    suspend fun createAccount(account: Account)
    val selectedCurrency: StateFlow<Currency>
}