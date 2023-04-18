package com.multithrifter.createaccount

import androidx.annotation.MainThread
import com.multithrifter.core.CoreApplication
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.extensions.demand
import com.multithrifter.createaccount.di.CreateAccountComponent
import com.multithrifter.createaccount.di.DaggerCreateAccountComponent
import com.multithrifter.db.DatabaseProviderFactory
import kotlinx.coroutines.flow.MutableSharedFlow

object CreateAccountFeature {

    var dependenciesProvider: ModuleDependenciesProvider<CreateAccountDependencies>? = null

    @MainThread
    fun getApi(): CreateAccountApi = component().getApi()

    private var createAccountComponent: CreateAccountComponent? by demand {
        val coreComponent = CoreApplication.app.coreComponent
        DaggerCreateAccountComponent.builder()
            .coreComponent(coreComponent)
            .createAccountDependencies(requireNotNull(dependenciesProvider?.getDependencies()))
            .databaseProvider(DatabaseProviderFactory.getDatabaseProvider(coreComponent))
            .build()
    }

    internal fun component(): CreateAccountComponent {
        return requireNotNull(createAccountComponent)
    }

    internal fun destroyComponent() {
        createAccountComponent = null
    }
}

interface CreateAccountDependencies {
    fun getCurrenciesActions(): CurrenciesActions
}

interface CurrenciesActions {
    fun showCurrenciesScreen(
        selectedCurrencyListener: MutableSharedFlow<Currency>,
        selectedCurrency: Currency? = null,
    )
}

