package com.multithrifter.accounts.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.multithrifter.accounts.domain.interactor.AccountsInteractor
import com.multithrifter.accounts.presentation.navigation.Router
import com.multithrifter.accounts.presentation.viewmodel.AccountsContract.AccountsEvent
import com.multithrifter.accounts.presentation.viewmodel.AccountsContract.AccountsEvent.AccountClicked
import com.multithrifter.accounts.presentation.viewmodel.AccountsContract.AccountsEvent.CreateAccountClicked
import com.multithrifter.accounts.presentation.viewmodel.AccountsContract.AccountsState
import com.multithrifter.core.viewmodel.CoreViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class AccountsViewModel @Inject constructor(
    private val interactor: AccountsInteractor,
    private val router: Router,
) : CoreViewModel<AccountsState, AccountsEvent>() {

    init {
        getAccounts()
        getTotals()
        getTotalsByCurrency()
    }

    override fun createInitialState() = AccountsState()

    override fun handleEvent(event: AccountsEvent) {
        when (event) {
            CreateAccountClicked -> router.showCreateAccountScreen()
            AccountClicked -> router.showEditAccountScreen()
        }
    }

    private fun getAccounts() {
        viewModelScope.launch {
            interactor.accountsFlow.collect { accounts ->
                setState { copy(accounts = accounts, isLoading = false) }
            }
        }
    }

    private fun getTotals() {
        viewModelScope.launch {
            interactor.totalsFlow.collect { totals ->
                setState { copy(totals = totals, isLoading = false) }
            }
        }
    }

    private fun getTotalsByCurrency() {
        viewModelScope.launch {
            interactor.totalsByCurrencyFlow.collect { totals ->
                setState { copy(totalsByCurrency = totals, isLoading = false) }
            }
        }
    }
}