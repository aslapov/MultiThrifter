package com.multithrifter.accounts

import androidx.annotation.MainThread
import com.multithrifter.accounts.di.DaggerAccountsComponent
import com.multithrifter.accounts.di.AccountsComponent
import com.multithrifter.core.CoreApplication
import com.multithrifter.core.di.ModuleDependenciesProvider
import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.extensions.demand
import com.multithrifter.db.DatabaseProviderFactory

object AccountsFeature {

    var dependenciesProvider: ModuleDependenciesProvider<AccountsDependencies>? = null

    @MainThread
    fun getApi(): AccountsApi = component().getApi()

    private var accountsComponent: AccountsComponent? by demand {
        val coreComponent = CoreApplication.app.coreComponent
        DaggerAccountsComponent.builder()
            .coreComponent(coreComponent)
            .accountsDependencies(requireNotNull(dependenciesProvider?.getDependencies()))
            .databaseProvider(DatabaseProviderFactory.getDatabaseProvider(coreComponent))
            .build()
    }

    internal fun component(): AccountsComponent {
        return requireNotNull(accountsComponent)
    }

    internal fun destroyComponent() {
        accountsComponent = null
    }
}

interface AccountsDependencies {
    fun getCreateAccountActions(): CreateAccountActions
    fun getEditAccountActions(): EditAccountActions
}

interface CreateAccountActions {
    fun showCreateAccountScreen()
}

interface EditAccountActions {
    fun showEditAccountScreen(account: Account)
}