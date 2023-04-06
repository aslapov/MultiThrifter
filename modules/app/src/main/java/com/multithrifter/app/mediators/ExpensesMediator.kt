package com.multithrifter.app.mediators

import androidx.annotation.MainThread
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.expenses.ExpensesDependencies
import com.multithrifter.expenses.ExpensesFeature

class ExpensesMediator {

    init {
        ExpensesFeature.dependenciesProvider = ModuleDependenciesProvider {
            getDependencies()
        }
    }

    @MainThread
    fun getApi() = ExpensesFeature.getApi()

    private fun getDependencies(): ExpensesDependencies {
        return object : ExpensesDependencies {}
    }
}