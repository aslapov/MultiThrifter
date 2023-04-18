package com.multithrifter.accounts

import com.multithrifter.accounts.presentation.navigation.Router
import javax.inject.Inject

internal class AccountsApiImpl @Inject constructor(
    private val router: Router,
) : AccountsApi {

    override fun showAccountsScreen() {
        router.showAccountsScreen()
    }
}