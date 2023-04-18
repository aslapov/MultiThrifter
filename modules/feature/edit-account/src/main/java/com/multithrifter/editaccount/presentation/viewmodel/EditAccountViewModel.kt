package com.multithrifter.editaccount.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.viewmodel.CoreViewModel
import com.multithrifter.editaccount.domain.interactor.EditAccountInteractor
import com.multithrifter.editaccount.presentation.navigation.Router
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.BalanceChanged
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.CancelClicked
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.CurrencyClicked
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.DeleteClicked
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.Initialize
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.NameChanged
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.SaveClicked
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.ValidationNotificationShown
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class EditAccountViewModel @Inject constructor(
    private val router: Router,
    private val interactor: EditAccountInteractor,
) : CoreViewModel<AccountState, AccountEvent>() {

    private val selectedCurrencyListener = MutableSharedFlow<Currency>()

    private var accountId: Int = 0

    init {
        subscribeSelectedCurrency()
    }

    override fun createInitialState() = AccountState()

    override fun handleEvent(event: AccountEvent) {
        when (event) {
            is Initialize -> initialize(event.account)
            CancelClicked -> router.onBack()
            is CurrencyClicked -> currencyClicked(event.selectedCurrency)
            ValidationNotificationShown -> resetNotificationState()
            SaveClicked -> saveClicked()
            DeleteClicked -> deleteClicked()
            is NameChanged -> nameChanged(event.name)
            is BalanceChanged -> balanceChanged(event.balance)
        }
    }

    private fun initialize(account: Account) {
        accountId = account.id
        setState {
            AccountState(
                name = account.name,
                balance = account.balance.toString(),
                selectedCurrency = account.currency,
            )
        }
    }

    private fun currencyClicked(currency: Currency) {
        router.showCurrenciesScreen(selectedCurrencyListener, currency)
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
            interactor.editAccount(Account(name, amount, currency, accountId))
            router.onBack()
        }
    }

    private fun showNotification() {
        setState { copy(showValidationNotification = true) }
    }

    private fun resetNotificationState() {
        setState { copy(showValidationNotification = false) }
    }
    
    private fun subscribeSelectedCurrency() {
        viewModelScope.launch {
            selectedCurrencyListener.collect { selectedCurrency ->
                setState { copy(selectedCurrency = selectedCurrency) }
            }
        }
    }

    private fun deleteClicked() {
        viewModelScope.launch {
            viewModelScope.launch {
                interactor.deleteAccount(accountId)
                router.onBack()
            }
        }
    }
}