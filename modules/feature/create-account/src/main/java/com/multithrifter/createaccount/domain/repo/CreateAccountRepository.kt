package com.multithrifter.createaccount.domain.repo

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency

internal interface CreateAccountRepository {
    suspend fun getCurrencies(): List<Currency>
    suspend fun createAccount(account: Account)
}