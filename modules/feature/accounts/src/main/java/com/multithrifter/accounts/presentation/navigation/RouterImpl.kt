package com.multithrifter.accounts.presentation.navigation

import com.multithrifter.accounts.CreateAccountActions
import com.multithrifter.accounts.EditAccountActions
import com.multithrifter.accounts.presentation.ui.AccountsFragment
import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.navigation.GlobalNavigator
import javax.inject.Inject

internal class RouterImpl @Inject constructor(
    private val navigator: GlobalNavigator,
    private val createAccountActions: CreateAccountActions,
    private val editAccountActions: EditAccountActions,
) : Router {

    override fun showAccountsScreen() {
        navigator.newRootFragment(AccountsFragment.newInstance())
    }

    override fun showCreateAccountScreen() {
        createAccountActions.showCreateAccountScreen()
    }

    override fun showEditAccountScreen(account: Account) {
        editAccountActions.showEditAccountScreen(account)
    }
}