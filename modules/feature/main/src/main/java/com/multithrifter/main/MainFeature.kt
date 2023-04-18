package com.multithrifter.main

import com.multithrifter.core.CoreApplication
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.core.extensions.demand
import com.multithrifter.db.DatabaseProviderFactory
import com.multithrifter.main.di.DaggerMainComponent
import com.multithrifter.main.di.MainComponent
import com.multithrifter.network.NetworkProviderFactory

object MainFeature {
    var dependenciesProvider: ModuleDependenciesProvider<MainDependencies>? = null
    
    private var mainComponent: MainComponent? by demand {
        val coreComponent = CoreApplication.app.coreComponent
        DaggerMainComponent.builder()
            .coreComponent(coreComponent)
            .mainDependencies(requireNotNull(dependenciesProvider?.getDependencies()))
            .databaseProvider(DatabaseProviderFactory.getDatabaseProvider(coreComponent))
            .networkProvider(NetworkProviderFactory.createNetworkProvider(coreComponent))
            .build()
    }

    internal fun component(): MainComponent {
        return requireNotNull(mainComponent)
    }

    internal fun destroyComponent() {
        mainComponent = null
    }
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