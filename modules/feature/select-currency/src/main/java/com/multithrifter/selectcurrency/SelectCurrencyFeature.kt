package com.multithrifter.selectcurrency

import androidx.annotation.MainThread
import com.multithrifter.core.CoreApplication
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.db.DatabaseProviderFactory
import com.multithrifter.selectcurrency.di.DaggerSelectCurrencyComponent
import com.multithrifter.selectcurrency.di.SelectCurrencyComponent
import com.multithrifter.selectcurrency.presentation.ui.SelectCurrencyFragment
import kotlinx.coroutines.flow.MutableSharedFlow

object SelectCurrencyFeature {

    private var component: SelectCurrencyComponent? = null

    @MainThread
    fun getApi(selectedCurrencyListener: MutableSharedFlow<Currency>): SelectCurrencyApi =
        component?.getApi() ?: run {
            val coreComponent = CoreApplication.app.coreComponent
            component = DaggerSelectCurrencyComponent.builder()
                .coreComponent(coreComponent)
                .selectedCurrencyListener(selectedCurrencyListener)
                .databaseProvider(DatabaseProviderFactory.createDatabaseProvider(coreComponent))
                .build()

            return requireNotNull(component).getApi()
        }

    internal fun inject(fragment: SelectCurrencyFragment) = requireNotNull(component).inject(fragment)

    internal fun destroyComponent() {
        component = null
    }
}