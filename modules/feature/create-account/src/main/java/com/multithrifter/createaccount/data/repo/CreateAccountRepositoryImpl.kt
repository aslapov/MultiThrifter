package com.multithrifter.createaccount.data.repo

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.createaccount.domain.repo.CreateAccountRepository
import com.multithrifter.dbapi.dao.AccountsDao
import com.multithrifter.dbapi.entity.AccountDbEntity
import javax.inject.Inject

internal class CreateAccountRepositoryImpl @Inject constructor(
    private val accountsDao: AccountsDao,
) : CreateAccountRepository {

    override suspend fun createAccount(account: Account) {
        accountsDao.createAccount(
            AccountDbEntity(
                name = account.name,
                balance = account.balance,
                currencyId = account.currency.id,
            )
        )
    }
}