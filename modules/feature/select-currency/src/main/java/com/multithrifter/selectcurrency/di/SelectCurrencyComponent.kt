package com.multithrifter.selectcurrency.di

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.core.di.ModuleScope
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.dbapi.DatabaseProvider
import com.multithrifter.selectcurrency.SelectCurrencyApi
import com.multithrifter.selectcurrency.presentation.ui.SelectCurrencyFragment
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.MutableSharedFlow

@ModuleScope
@Component(
    dependencies = [
        CoreComponent::class,
        DatabaseProvider::class,
    ],
    modules = [SelectCurrencyModule::class],
)
internal interface SelectCurrencyComponent {

    @Component.Builder
    interface Builder {

        fun coreComponent(coreComponent: CoreComponent): Builder

        @BindsInstance
        fun selectedCurrencyListener(listener: MutableSharedFlow<Currency>): Builder

        fun databaseProvider(databaseProvider: DatabaseProvider): Builder

        fun build(): SelectCurrencyComponent
    }

    fun getApi(): SelectCurrencyApi

    fun inject(fragment: SelectCurrencyFragment)
}