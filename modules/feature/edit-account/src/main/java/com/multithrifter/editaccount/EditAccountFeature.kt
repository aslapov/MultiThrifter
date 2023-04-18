package com.multithrifter.editaccount

import androidx.annotation.MainThread
import com.multithrifter.core.CoreApplication
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.extensions.demand
import com.multithrifter.editaccount.di.DaggerEditAccountComponent
import com.multithrifter.editaccount.di.EditAccountComponent
import com.multithrifter.db.DatabaseProviderFactory
import kotlinx.coroutines.flow.MutableSharedFlow

object EditAccountFeature {

    var dependenciesProvider: ModuleDependenciesProvider<EditAccountDependencies>? = null

    @MainThread
    fun getApi(): EditAccountApi = component().getApi()

    private var editAccountComponent: EditAccountComponent? by demand {
        val coreComponent = CoreApplication.app.coreComponent
        DaggerEditAccountComponent.builder()
            .coreComponent(coreComponent)
            .editAccountDependencies(requireNotNull(dependenciesProvider?.getDependencies()))
            .databaseProvider(DatabaseProviderFactory.createDatabaseProvider(coreComponent))
            .build()
    }

    internal fun component(): EditAccountComponent {
        return requireNotNull(editAccountComponent)
    }

    internal fun destroyComponent() {
        editAccountComponent = null
    }
}

interface EditAccountDependencies {
    fun getCurrenciesActions(): CurrenciesActions
}

interface CurrenciesActions {
    fun showCurrenciesScreen(
        selectedCurrencyListener: MutableSharedFlow<Currency>,
        selectedCurrency: Currency? = null,
    )
}

