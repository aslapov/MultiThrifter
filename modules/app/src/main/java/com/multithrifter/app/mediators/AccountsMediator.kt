package com.multithrifter.app.mediators

import androidx.annotation.MainThread
import com.multithrifter.accounts.AccountsDependencies
import com.multithrifter.accounts.AccountsFeature
import com.multithrifter.core.di.ModuleDependenciesProvider

class AccountsMediator {

    init {
        AccountsFeature.dependenciesProvider = ModuleDependenciesProvider {
            getDependencies()
        }
    }

    @MainThread
    fun getApi() = AccountsFeature.getApi()

    private fun getDependencies(): AccountsDependencies {
        return object : AccountsDependencies {}
    }
}