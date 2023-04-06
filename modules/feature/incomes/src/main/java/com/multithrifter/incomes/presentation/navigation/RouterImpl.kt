package com.multithrifter.incomes.presentation.navigation

import com.multithrifter.core.navigation.GlobalNavigator
import com.multithrifter.incomes.presentation.ui.IncomesFragment
import javax.inject.Inject

class RouterImpl @Inject constructor(
    private val navigator: GlobalNavigator,
) : Router {

    override fun showIncomesScreen() {
        navigator.newRootFragment(IncomesFragment.newInstance())
    }

    override fun onBack() = navigator.back()
}