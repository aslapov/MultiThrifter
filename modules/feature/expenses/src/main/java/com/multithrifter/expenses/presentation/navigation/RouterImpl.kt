package com.multithrifter.expenses.presentation.navigation

import com.multithrifter.core.navigation.GlobalNavigator
import com.multithrifter.expenses.presentation.ui.ExpensesFragment
import javax.inject.Inject

class RouterImpl @Inject constructor(
    private val navigator: GlobalNavigator,
) : Router {

    override fun showExpensesScreen() {
        navigator.newRootFragment(ExpensesFragment.newInstance())
    }

    override fun onBack() = navigator.back()
}