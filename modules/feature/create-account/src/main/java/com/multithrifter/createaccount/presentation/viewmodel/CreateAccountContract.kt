package com.multithrifter.createaccount.presentation.viewmodel

import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.viewmodel.UiEvent
import com.multithrifter.core.viewmodel.UiState

internal object CreateAccountContract {

    data class AccountState(
        val name: String = "",
        val balance: String = "0",
        val selectedCurrency: Currency = Currency.default(),
        val showValidationNotification: Boolean = false,
    ) : UiState

    sealed class AccountEvent : UiEvent {
        object CancelClicked : AccountEvent()
        object CurrencyClicked : AccountEvent()
        object ValidationNotificationShown : AccountEvent()
        data class NameChanged(val name: String) : AccountEvent()
        data class BalanceChanged(val balance: String) : AccountEvent()
        object SaveClicked : AccountEvent()
    }
}