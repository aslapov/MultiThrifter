package com.multithrifter.editaccount.presentation.viewmodel

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.viewmodel.UiEvent
import com.multithrifter.core.viewmodel.UiState

internal object EditAccountContract {

    data class AccountState(
        val name: String = "",
        val balance: String = "0",
        val selectedCurrency: Currency = Currency.default(),
        val showValidationNotification: Boolean = false,
    ) : UiState

    sealed class AccountEvent : UiEvent {
        data class Initialize(val account: Account) : AccountEvent()
        object CancelClicked : AccountEvent()
        data class CurrencyClicked(val selectedCurrency: Currency) : AccountEvent()
        object ValidationNotificationShown : AccountEvent()
        data class NameChanged(val name: String) : AccountEvent()
        data class BalanceChanged(val balance: String) : AccountEvent()
        object SaveClicked : AccountEvent()
        object DeleteClicked : AccountEvent()
    }
}