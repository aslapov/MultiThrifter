package com.multithrifter.createaccount.data.repo

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.createaccount.domain.repo.CreateAccountRepository
import com.multithrifter.dbapi.dao.AccountsDao
import com.multithrifter.dbapi.entity.AccountDbEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class CreateAccountRepositoryImpl @Inject constructor(
    private val accountsDao: AccountsDao,
) : CreateAccountRepository {

    private val _selectedCurrency = MutableStateFlow(Currency.default())

    override val selectedCurrency: StateFlow<Currency> = _selectedCurrency

    override fun updateSelectedCurrency(currency: Currency) {
        _selectedCurrency.value = currency
    }

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