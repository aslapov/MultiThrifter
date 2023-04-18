package com.multithrifter.accounts.presentation.navigation

import com.multithrifter.core.domain.entity.Account

internal interface Router {
    fun showAccountsScreen()
    fun showCreateAccountScreen()
    fun showEditAccountScreen(account: Account)
}