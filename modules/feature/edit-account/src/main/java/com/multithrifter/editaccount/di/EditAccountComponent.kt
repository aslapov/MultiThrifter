package com.multithrifter.editaccount.di

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.core.di.ModuleScope
import com.multithrifter.editaccount.EditAccountApi
import com.multithrifter.editaccount.EditAccountDependencies
import com.multithrifter.editaccount.presentation.ui.EditAccountFragment
import com.multithrifter.dbapi.DatabaseProvider
import dagger.Component

@ModuleScope
@Component(
    dependencies = [
        CoreComponent::class,
        EditAccountDependencies::class,
        DatabaseProvider::class,
    ],
    modules = [EditAccountModule::class]
)
internal interface EditAccountComponent {

    fun getApi(): EditAccountApi

    fun inject(fragment: EditAccountFragment)
}