package com.multithrifter.app.mediators

import androidx.annotation.MainThread
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.incomes.IncomesDependencies
import com.multithrifter.incomes.IncomesFeature

class IncomesMediator {

    init {
        IncomesFeature.dependenciesProvider = ModuleDependenciesProvider {
            getDependencies()
        }
    }

    @MainThread
    fun getApi() = IncomesFeature.getApi()

    private fun getDependencies(): IncomesDependencies {
        return object : IncomesDependencies {}
    }
}