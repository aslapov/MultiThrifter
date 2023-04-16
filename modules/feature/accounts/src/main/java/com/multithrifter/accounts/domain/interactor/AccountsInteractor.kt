package com.multithrifter.accounts.domain.interactor

import com.multithrifter.accounts.domain.entity.TotalEntity
import com.multithrifter.core.domain.entity.Account
import kotlinx.coroutines.flow.Flow

internal interface AccountsInteractor {
    val accountsFlow: Flow<List<Account>>
    val totalsFlow: Flow<List<TotalEntity>>
    val totalsByCurrencyFlow: Flow<List<TotalEntity>>
}