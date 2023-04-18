package com.multithrifter.editaccount.domain.repo

import com.multithrifter.core.domain.entity.Account

internal interface EditAccountRepository {
    suspend fun editAccount(account: Account)
    suspend fun deleteAccount(accountId: Int)
}