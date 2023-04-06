package com.multithrifter.app.mediators

import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.main.AccountsActions
import com.multithrifter.main.ExpensesActions
import com.multithrifter.main.IncomesActions
import com.multithrifter.main.MainDependencies
import com.multithrifter.main.MainFeature

class MainMediator {

    init {
        MainFeature.dependenciesProvider = ModuleDependenciesProvider {
            getDependencies()
        }
    }

    private fun getDependencies(): MainDependencies {
        return object : MainDependencies {
            override fun getExpensesActions(): ExpensesActions {
                return object : ExpensesActions {
                    override fun showExpensesScreen() {
                        MediatorManager.expensesMediator.getApi().showExpensesScreen()
                    }
                }
            }

            override fun getIncomesActions(): IncomesActions {
                return object : IncomesActions {
                    override fun showIncomesScreen() {
                        MediatorManager.incomesMediator.getApi().showIncomesScreen()
                    }
                }
            }

            override fun getAccountsActions(): AccountsActions {
                return object : AccountsActions {
                    override fun showAccountsScreen() {
                        MediatorManager.accountsMediator.getApi().showAccountsScreen()
                    }
                }
            }
        }
    }
}