package com.multithrifter.app.mediators

object MediatorManager {
    fun init() {
        MainMediator()
    }

    val accountsMediator: AccountsMediator = AccountsMediator()
    val createAccountMediator: CreateAccountMediator = CreateAccountMediator()
    val editAccountMediator: EditAccountMediator = EditAccountMediator()
    val expensesMediator: ExpensesMediator = ExpensesMediator()
    val incomesMediator: IncomesMediator = IncomesMediator()
    val selectCurrencyMediator: SelectCurrencyMediator = SelectCurrencyMediator()
}