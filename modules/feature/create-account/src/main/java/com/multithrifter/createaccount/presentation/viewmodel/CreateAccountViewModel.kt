package com.multithrifter.createaccount.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.viewmodel.CoreViewModel
import com.multithrifter.createaccount.domain.interactor.CreateAccountInteractor
import com.multithrifter.createaccount.presentation.navigation.Router
import com.multithrifter.createaccount.presentation.viewmodel.CreateAccountContract.AccountEvent
import com.multithrifter.createaccount.presentation.viewmodel.CreateAccountContract.AccountEvent.BalanceChanged
import com.multithrifter.createaccount.presentation.viewmodel.CreateAccountContract.AccountEvent.CancelClicked
import com.multithrifter.createaccount.presentation.viewmodel.CreateAccountContract.AccountEvent.CurrencyClicked
import com.multithrifter.createaccount.presentation.viewmodel.CreateAccountContract.AccountEvent.NameChanged
import com.multithrifter.createaccount.presentation.viewmodel.CreateAccountContract.AccountEvent.SaveClicked
import com.multithrifter.createaccount.presentation.viewmodel.CreateAccountContract.AccountEvent.ValidationNotificationShown
import com.multithrifter.createaccount.presentation.viewmodel.CreateAccountContract.AccountState
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class CreateAccountViewModel @Inject constructor(
    private val router: Router,
    private val interactor: CreateAccountInteractor,
) : CoreViewModel<AccountState, AccountEvent>() {

    override fun createInitialState() = AccountState()

    override fun handleEvent(event: AccountEvent) {
        when (event) {
            CancelClicked -> router.onBack()
            CurrencyClicked -> router.showCurrenciesScreen()
            ValidationNotificationShown -> resetNotificationState()
            SaveClicked -> saveClicked()
            is NameChanged -> nameChanged(event.name)
            is BalanceChanged -> balanceChanged(event.balance)
        }
    }

    private fun nameChanged(name: String) {
        setState { copy(name = name) }
    }

    private fun balanceChanged(balance: String) {
        setState { copy(balance = balance.replace(',', '.')) }
    }

    private fun saveClicked() {
        val currentState = uiState.value
        if (validate()) {
            saveAccount(currentState.name, currentState.balance.toFloat(), currentState.selectedCurrency)
        } else {
            showNotification()
        }
    }

    private fun validate(): Boolean {
        return currentState.name.isNotEmpty() && runCatching { currentState.balance.toFloat() }.isSuccess
    }

    private fun saveAccount(name: String, amount: Float, currency: Currency) {
        viewModelScope.launch {
            interactor.createAccount(Account(name, amount, currency))
            router.onBack()
        }
    }

    private fun showNotification() {
        setState { copy(showValidationNotification = true) }
    }

    private fun resetNotificationState() {
        setState { copy(showValidationNotification = false) }
    }
}