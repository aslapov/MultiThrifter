package com.multithrifter.app.mediators

object MediatorManager {
    fun init() {
        MainMediator()
    }

    val accountsMediator: AccountsMediator = AccountsMediator()
    val createAccountMediator: CreateAccountMediator = CreateAccountMediator()
    val expensesMediator: ExpensesMediator = ExpensesMediator()
    val incomesMediator: IncomesMediator = IncomesMediator()
}