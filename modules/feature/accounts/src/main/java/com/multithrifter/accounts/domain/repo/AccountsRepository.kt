package com.multithrifter.accounts.domain.repo

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.ExchangeRate
import kotlinx.coroutines.flow.Flow

internal interface AccountsRepository {
    val accounts: Flow<List<Account>>
    fun getLatestCurrencyRateGroups(currencyIds: Set<String>): Flow<List<ExchangeRate>>
}