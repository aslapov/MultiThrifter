package com.multithrifter.accounts.presentation.viewmodel

import com.multithrifter.accounts.domain.interactor.AccountsInteractor
import com.multithrifter.accounts.fixture.accounts
import com.multithrifter.accounts.fixture.totals
import com.multithrifter.accounts.fixture.totalsByCurrency
import com.multithrifter.accounts.fixture.usdAccount
import com.multithrifter.accounts.presentation.navigation.Router
import com.multithrifter.accounts.presentation.viewmodel.AccountsContract.AccountsEvent.AccountClicked
import com.multithrifter.accounts.presentation.viewmodel.AccountsContract.AccountsEvent.CreateAccountClicked
import com.multithrifter.accounts.presentation.viewmodel.AccountsContract.AccountsState
import com.multithrifter.coretest.CoreTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

internal class AccountsViewModelTest : CoreTest() {

    private val interactor: AccountsInteractor = mockk {
        every { accountsFlow } returns flowOf(accounts)
        every { totalsFlow } returns flowOf(totals)
        every { totalsByCurrencyFlow } returns flowOf(totalsByCurrency)
    }

    private val router: Router = mockk {
        every { showCreateAccountScreen() } returns Unit
        every { showEditAccountScreen(any()) } returns Unit
    }

    private val viewModel: AccountsViewModel by lazy { AccountsViewModel(interactor, router) }

    @Test
    fun `when viewModel is created - then appropriate state`() {
        // Given
        val state = AccountsState(
            accounts = accounts,
            totals = totals,
            totalsByCurrency = totalsByCurrency,
            isLoading = false,
        )

        // Then
        then(viewModel.currentState).isEqualTo(state)
    }

    @Test
    fun `when user clicks create account - then show create account screen`() {
        // When
        viewModel.handleEvent(CreateAccountClicked)

        // Then
        verify { router.showCreateAccountScreen() }
    }

    @Test
    fun `when user clicks on account item - then show create account screen`() {
        // When
        viewModel.handleEvent(AccountClicked(usdAccount))

        // Then
        verify { router.showEditAccountScreen(usdAccount) }
    }
}