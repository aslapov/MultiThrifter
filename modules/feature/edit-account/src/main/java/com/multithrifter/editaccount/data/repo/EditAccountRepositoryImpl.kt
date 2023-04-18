package com.multithrifter.editaccount.data.repo

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.dbapi.dao.AccountsDao
import com.multithrifter.dbapi.entity.AccountDbEntity
import com.multithrifter.editaccount.domain.repo.EditAccountRepository
import javax.inject.Inject

internal class EditAccountRepositoryImpl @Inject constructor(
    private val accountsDao: AccountsDao,
) : EditAccountRepository {

    override suspend fun editAccount(account: Account) {
        accountsDao.updateAccount(
            AccountDbEntity(
                id = account.id,
                name = account.name,
                balance = account.balance,
                currencyId = account.currency.id,
            )
        )
    }

    override suspend fun deleteAccount(accountId: Int) {
        accountsDao.deleteAccount(accountId)
    }
}