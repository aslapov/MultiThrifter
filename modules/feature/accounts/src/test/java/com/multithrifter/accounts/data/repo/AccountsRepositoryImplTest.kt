package com.multithrifter.accounts.data.repo

import com.multithrifter.accounts.data.mapper.AccountMapper
import com.multithrifter.accounts.data.mapper.AccountMapperImpl
import com.multithrifter.accounts.data.mapper.CurrencyRateMapper
import com.multithrifter.accounts.data.mapper.CurrencyRateMapperImpl
import com.multithrifter.accounts.fixture.accounts
import com.multithrifter.accounts.fixture.accountsDtoFlow
import com.multithrifter.accounts.fixture.exchangeRates
import com.multithrifter.accounts.fixture.exchangeRatesFlow
import com.multithrifter.coretest.CoreTest
import com.multithrifter.dbapi.dao.AccountsDao
import com.multithrifter.dbapi.dao.RatesDao
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class AccountsRepositoryImplTest : CoreTest() {

    private val accountsDao: AccountsDao = mockk {
        every { getAccounts() } returns accountsDtoFlow
        coEvery { createAccount(any()) } returns Unit
        coEvery { updateAccount(any()) } returns Unit
        coEvery { deleteAccount(any()) } returns Unit
    }

    private val ratesDao: RatesDao = mockk {
        every { getLatestExchangeRateGroups(any()) } returns exchangeRatesFlow
        coEvery { createExchangeRate(any()) } returns Unit
    }

    private val currencyRateMapper: CurrencyRateMapper = CurrencyRateMapperImpl()
    private val accountMapper: AccountMapper = AccountMapperImpl()

    private val repository by lazy {
        AccountsRepositoryImpl(accountsDao, ratesDao, currencyRateMapper, accountMapper)
    }

    @Test
    fun `when get accounts - then appropriate answer`() = runTest {
        // When
        val accountsResult = repository.accounts.firstOrNull()

        // Then
        verify { accountsDao.getAccounts() }
        then(accountsResult).isEqualTo(accounts)
    }

    @Test
    fun `when get exchange rates - then appropriate answer`() = runTest {
        // When
        val ratesResult = repository.getLatestCurrencyRateGroups(setOf()).firstOrNull()

        // Then
        verify { ratesDao.getLatestExchangeRateGroups(setOf()) }
        then(ratesResult).isEqualTo(exchangeRates)
    }
}