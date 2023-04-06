package com.multithrifter.app.mediators

object MediatorManager {
    fun init() {
        MainMediator()
    }

    val accountsMediator: AccountsMediator = AccountsMediator()
    val expensesMediator: ExpensesMediator = ExpensesMediator()
    val incomesMediator: IncomesMediator = IncomesMediator()
}