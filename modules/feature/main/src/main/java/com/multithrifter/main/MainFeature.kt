package com.multithrifter.main

import com.multithrifter.core.di.ModuleDependenciesProvider

object MainFeature {
    var dependenciesProvider: ModuleDependenciesProvider<MainDependencies>? = null
}

interface MainDependencies {
    fun getExpensesActions(): ExpensesActions
    fun getIncomesActions(): IncomesActions
    fun getAccountsActions(): AccountsActions
}

interface ExpensesActions {
    fun showExpensesScreen()
}

interface IncomesActions {
    fun showIncomesScreen()
}

interface AccountsActions {
    fun showAccountsScreen()
}