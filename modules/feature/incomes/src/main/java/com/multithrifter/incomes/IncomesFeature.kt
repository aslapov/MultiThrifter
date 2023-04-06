package com.multithrifter.incomes

import androidx.annotation.MainThread
import com.multithrifter.core.CoreApplication
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.core.extensions.demand
import com.multithrifter.incomes.di.DaggerIncomesComponent
import com.multithrifter.incomes.di.IncomesComponent

object IncomesFeature {

    var dependenciesProvider: ModuleDependenciesProvider<IncomesDependencies>? = null

    @MainThread
    fun getApi(): IncomesApi = component().getApi()

    private var incomesComponent: IncomesComponent? by demand {
        DaggerIncomesComponent.builder()
            .coreComponent(CoreApplication.app.coreComponent)
            .incomesDependencies(requireNotNull(dependenciesProvider?.getDependencies()))
            .build()
    }

    internal fun component(): IncomesComponent {
        return requireNotNull(incomesComponent)
    }

    internal fun destroyComponent() {
        incomesComponent = null
    }
}

interface IncomesDependencies