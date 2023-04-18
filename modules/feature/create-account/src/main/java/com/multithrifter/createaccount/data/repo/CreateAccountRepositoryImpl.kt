package com.multithrifter.createaccount.data.repo

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.createaccount.data.mapper.CurrencyMapper
import com.multithrifter.createaccount.domain.repo.CreateAccountRepository
import com.multithrifter.dbapi.dao.AccountsDao
import com.multithrifter.dbapi.dao.CurrencyDao
import com.multithrifter.dbapi.entity.AccountDbEntity
import javax.inject.Inject

internal class CreateAccountRepositoryImpl @Inject constructor(
    private val accountsDao: AccountsDao,
    private val currencyDao: CurrencyDao,
    private val currencyMapper: CurrencyMapper,
) : CreateAccountRepository {

    override suspend fun getCurrencies() = currencyDao.getCurrencies().map(currencyMapper::map)

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