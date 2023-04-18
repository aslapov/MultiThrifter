package com.multithrifter.createaccount.domain.repo

import com.multithrifter.core.domain.entity.Account

internal interface CreateAccountRepository {
    suspend fun createAccount(account: Account)
}