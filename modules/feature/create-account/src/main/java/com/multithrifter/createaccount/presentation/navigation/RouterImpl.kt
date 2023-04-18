package com.multithrifter.createaccount.presentation.navigation

import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.navigation.GlobalNavigator
import com.multithrifter.createaccount.CurrenciesActions
import com.multithrifter.createaccount.presentation.ui.CreateAccountFragment
import javax.inject.Inject

internal class RouterImpl @Inject constructor(
    private val navigator: GlobalNavigator,
    private val currenciesActions: CurrenciesActions,
) : Router {

    override fun showCreateAccountScreen() {
        navigator.openFullScreenFragment(CreateAccountFragment.newInstance(), true)
    }

    override fun showCurrenciesScreen(selectedCurrency: Currency?) {
        currenciesActions.showCurrenciesScreen(selectedCurrency)
    }

    override fun onBack() = navigator.back()
}