package com.multithrifter.createaccount.domain.interactor

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency

internal interface CreateAccountInteractor {
    suspend fun getCurrencies(): List<Currency>
    suspend fun createAccount(account: Account)
}