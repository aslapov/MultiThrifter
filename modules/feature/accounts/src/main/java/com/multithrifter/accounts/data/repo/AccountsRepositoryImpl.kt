package com.multithrifter.accounts.data.repo

import com.multithrifter.accounts.data.mapper.AccountMapper
import com.multithrifter.accounts.data.mapper.CurrencyRateMapper
import com.multithrifter.accounts.domain.repo.AccountsRepository
import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.ExchangeRate
import com.multithrifter.dbapi.dao.AccountsDao
import com.multithrifter.dbapi.dao.RatesDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class AccountsRepositoryImpl @Inject constructor(
    accountsDao: AccountsDao,
    private val ratesDao: RatesDao,
    private val currencyRateMapper: CurrencyRateMapper,
    private val accountMapper: AccountMapper,
) : AccountsRepository {

    override val accounts: Flow<List<Account>> = accountsDao.getAccounts()
        .map { accounts ->  accounts.map(accountMapper::map) }

    override fun getLatestCurrencyRateGroups(currencyIds: Set<String>): Flow<List<ExchangeRate>> {
        return ratesDao.getLatestExchangeRateGroups(currencyIds)
            .map { rates -> rates.map(currencyRateMapper::map) }
    }
}