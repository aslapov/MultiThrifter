package com.multithrifter.createaccount.di

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.core.di.ModuleScope
import com.multithrifter.createaccount.CreateAccountApi
import com.multithrifter.createaccount.CreateAccountDependencies
import com.multithrifter.createaccount.presentation.ui.CreateAccountFragment
import com.multithrifter.dbapi.DatabaseProvider
import dagger.Component

@ModuleScope
@Component(
    dependencies = [
        CoreComponent::class,
        CreateAccountDependencies::class,
        DatabaseProvider::class,
    ],
    modules = [CreateAccountModule::class]
)
internal interface CreateAccountComponent {

    fun getApi(): CreateAccountApi

    fun inject(fragment: CreateAccountFragment)
}