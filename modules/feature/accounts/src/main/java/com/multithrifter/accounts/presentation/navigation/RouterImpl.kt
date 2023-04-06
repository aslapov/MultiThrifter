package com.multithrifter.accounts.presentation.navigation

import com.multithrifter.accounts.presentation.ui.AccountsFragment
import com.multithrifter.core.navigation.GlobalNavigator
import javax.inject.Inject

class RouterImpl @Inject constructor(
    private val navigator: GlobalNavigator,
) : Router {

    override fun showAccountsScreen() {
        navigator.newRootFragment(AccountsFragment.newInstance())
    }

    override fun onBack() = navigator.back()
}