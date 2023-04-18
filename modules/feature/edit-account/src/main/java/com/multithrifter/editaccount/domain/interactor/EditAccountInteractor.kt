package com.multithrifter.editaccount.domain.interactor

import com.multithrifter.core.domain.entity.Account

internal interface EditAccountInteractor {
    suspend fun editAccount(account: Account)
    suspend fun deleteAccount(accountId: Int)
}