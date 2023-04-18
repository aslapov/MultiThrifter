package com.multithrifter.selectcurrency

import androidx.annotation.MainThread
import com.multithrifter.core.CoreApplication
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.extensions.demand
import com.multithrifter.db.DatabaseProviderFactory
import com.multithrifter.selectcurrency.di.DaggerSelectCurrencyComponent
import com.multithrifter.selectcurrency.di.SelectCurrencyComponent

object SelectCurrencyFeature {

    var dependenciesProvider: ModuleDependenciesProvider<SelectCurrencyDependencies>? = null

    @MainThread
    fun getApi(): SelectCurrencyApi = component().getApi()

    private var selectCurrencyComponent: SelectCurrencyComponent? by demand {
        val coreComponent = CoreApplication.app.coreComponent
        DaggerSelectCurrencyComponent.builder()
            .coreComponent(coreComponent)
            .selectCurrencyDependencies(requireNotNull(dependenciesProvider?.getDependencies()))
            .databaseProvider(DatabaseProviderFactory.createDatabaseProvider(coreComponent))
            .build()
    }

    internal fun component(): SelectCurrencyComponent {
        return requireNotNull(selectCurrencyComponent)
    }

    internal fun destroyComponent() {
        selectCurrencyComponent = null
    }
}

interface SelectCurrencyDependencies {
    fun getSelectedCurrencyListenerActions(): SelectedCurrencyListenerActions
}

interface SelectedCurrencyListenerActions {
    fun updateSelectedCurrency(currency: Currency)
}