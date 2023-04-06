package com.multithrifter.accounts

import androidx.annotation.MainThread
import com.multithrifter.accounts.di.DaggerAccountsComponent
import com.multithrifter.accounts.di.AccountsComponent
import com.multithrifter.core.CoreApplication
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.core.extensions.demand

object AccountsFeature {

    var dependenciesProvider: ModuleDependenciesProvider<AccountsDependencies>? = null

    @MainThread
    fun getApi(): AccountsApi = component().getApi()

    private var accountsComponent: AccountsComponent? by demand {
        DaggerAccountsComponent.builder()
            .coreComponent(CoreApplication.app.coreComponent)
            .accountsDependencies(requireNotNull(dependenciesProvider?.getDependencies()))
            .build()
    }

    internal fun component(): AccountsComponent {
        return requireNotNull(accountsComponent)
    }

    internal fun destroyComponent() {
        accountsComponent = null
    }
}

interface AccountsDependencies