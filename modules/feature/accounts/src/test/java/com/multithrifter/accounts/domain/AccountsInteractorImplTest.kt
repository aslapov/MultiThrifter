package com.multithrifter.accounts.domain

import com.multithrifter.accounts.domain.interactor.AccountsInteractor
import com.multithrifter.accounts.domain.interactor.AccountsInteractorImpl
import com.multithrifter.accounts.domain.repo.AccountsRepository
import com.multithrifter.accounts.fixture.accountsFlow
import com.multithrifter.accounts.fixture.exchangeRates
import com.multithrifter.accounts.fixture.gel
import com.multithrifter.accounts.fixture.rub
import com.multithrifter.accounts.fixture.totals
import com.multithrifter.accounts.fixture.totalsByCurrency
import com.multithrifter.accounts.fixture.usd
import com.multithrifter.coretest.CoreTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

@OptIn(ExperimentalCoroutinesApi::class)
internal class AccountsInteractorImplTest : CoreTest() {

    private val repository: AccountsRepository = mockk {
        every { accounts }  returns accountsFlow
        every { getLatestCurrencyRateGroups(any()) } returns flowOf(exchangeRates)
    }

    private val interactor: AccountsInteractor by lazy { AccountsInteractorImpl(repository) }

    @Test
    fun `when get totals - then appropriate answer`() = runTest {
        // When
        val totalsResult = interactor.totalsFlow.firstOrNull()

        // Then
        then(totalsResult).isEqualTo(totals)
    }

    @Test
    fun `when get totals by currency - then appropriate answer`() = runTest {
        // When
        val totalsByCurrencyResult = interactor.totalsByCurrencyFlow.firstOrNull()

        // Then
        verify { repository.getLatestCurrencyRateGroups(setOf(rub.id, usd.id, gel.id)) }
        then(totalsByCurrencyResult).isEqualTo(totalsByCurrency)
    }
}