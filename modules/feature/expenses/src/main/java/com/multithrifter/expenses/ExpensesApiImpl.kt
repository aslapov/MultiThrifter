package com.multithrifter.expenses

import com.multithrifter.expenses.presentation.navigation.Router
import javax.inject.Inject

class ExpensesApiImpl @Inject constructor(
    private val router: Router,
) : ExpensesApi {

    override fun showExpensesScreen() {
        router.showExpensesScreen()
    }
}