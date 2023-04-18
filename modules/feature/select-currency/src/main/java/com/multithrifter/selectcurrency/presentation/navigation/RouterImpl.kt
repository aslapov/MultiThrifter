package com.multithrifter.selectcurrency.presentation.navigation

import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.navigation.GlobalNavigator
import com.multithrifter.selectcurrency.presentation.ui.SelectCurrencyFragment
import javax.inject.Inject

internal class RouterImpl @Inject constructor(
    private val navigator: GlobalNavigator,
) : Router {

    override fun showSelectCurrencyScreen(currency: Currency?) {
        navigator.openFullScreenFragment(SelectCurrencyFragment.newInstance(currency), true)
    }

    override fun onBack() = navigator.back()
}