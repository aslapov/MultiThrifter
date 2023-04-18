package com.multithrifter.createaccount.domain.interactor

import com.multithrifter.core.domain.entity.Account

internal interface CreateAccountInteractor {
    suspend fun createAccount(account: Account)
}