package com.multithrifter.selectcurrency.di

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.core.di.ModuleScope
import com.multithrifter.dbapi.DatabaseProvider
import com.multithrifter.selectcurrency.SelectCurrencyApi
import com.multithrifter.selectcurrency.SelectCurrencyDependencies
import com.multithrifter.selectcurrency.presentation.ui.SelectCurrencyFragment
import dagger.Component

@ModuleScope
@Component(
    dependencies = [
        CoreComponent::class,
        SelectCurrencyDependencies::class,
        DatabaseProvider::class,
    ],
    modules = [SelectCurrencyModule::class],
)
internal interface SelectCurrencyComponent {

    fun getApi(): SelectCurrencyApi

    fun inject(fragment: SelectCurrencyFragment)
}