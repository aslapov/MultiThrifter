package com.multithrifter.editaccount.presentation.navigation

import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.navigation.GlobalNavigator
import com.multithrifter.editaccount.CurrenciesActions
import com.multithrifter.editaccount.presentation.ui.EditAccountFragment
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

internal class RouterImpl @Inject constructor(
    private val navigator: GlobalNavigator,
    private val currenciesActions: CurrenciesActions,
) : Router {

    override fun showEditAccountScreen(account: Account) {
        navigator.openFullScreenFragment(EditAccountFragment.newInstance(account), true)
    }

    override fun showCurrenciesScreen(
        selectedCurrencyListener: MutableSharedFlow<Currency>,
        currency: Currency?,
    ) {
        currenciesActions.showCurrenciesScreen(selectedCurrencyListener, currency)
    }

    override fun onBack() = navigator.back()
}