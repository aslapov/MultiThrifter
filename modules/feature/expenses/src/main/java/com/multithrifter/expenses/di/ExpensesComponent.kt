package com.multithrifter.expenses.di

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.core.di.ModuleScope
import com.multithrifter.expenses.ExpensesApi
import com.multithrifter.expenses.ExpensesDependencies
import com.multithrifter.expenses.presentation.ui.ExpensesFragment
import dagger.Component

@ModuleScope
@Component(
    dependencies = [CoreComponent::class, ExpensesDependencies::class],
    modules = [ExpensesModule::class],
)
interface ExpensesComponent {

    fun getApi(): ExpensesApi

    fun inject(fragment: ExpensesFragment)
}