package com.multithrifter.accounts.presentation.viewmodel

import com.multithrifter.accounts.domain.entity.TotalEntity
import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.viewmodel.UiEvent
import com.multithrifter.core.viewmodel.UiState

object AccountsContract {

    data class AccountsState(
        val accounts: List<Account> = emptyList(),
        val totals: List<TotalEntity> = emptyList(),
        val totalsByCurrency: List<TotalEntity> = emptyList(),
        val isLoading: Boolean = true,
    ) : UiState

    sealed class AccountsEvent : UiEvent {
        object CreateAccountClicked : AccountsEvent()
        object AccountClicked : AccountsEvent()
    }
}