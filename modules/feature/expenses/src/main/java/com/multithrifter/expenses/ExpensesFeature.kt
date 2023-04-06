package com.multithrifter.expenses

import androidx.annotation.MainThread
import com.multithrifter.core.CoreApplication
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.core.extensions.demand
import com.multithrifter.expenses.di.DaggerExpensesComponent
import com.multithrifter.expenses.di.ExpensesComponent

object ExpensesFeature {

    var dependenciesProvider: ModuleDependenciesProvider<ExpensesDependencies>? = null

    @MainThread
    fun getApi(): ExpensesApi = component().getApi()

    private var expensesComponent: ExpensesComponent? by demand {
        DaggerExpensesComponent.builder()
            .coreComponent(CoreApplication.app.coreComponent)
            .expensesDependencies(requireNotNull(dependenciesProvider?.getDependencies()))
            .build()
    }

    internal fun component(): ExpensesComponent {
        return requireNotNull(expensesComponent)
    }

    internal fun destroyComponent() {
        expensesComponent = null
    }
}

interface ExpensesDependencies