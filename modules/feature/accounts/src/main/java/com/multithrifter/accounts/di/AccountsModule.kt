package com.multithrifter.accounts.di

import com.multithrifter.accounts.AccountsApi
import com.multithrifter.accounts.AccountsApiImpl
import com.multithrifter.accounts.presentation.navigation.Router
import com.multithrifter.accounts.presentation.navigation.RouterImpl
import com.multithrifter.core.di.ModuleScope
import dagger.Binds
import dagger.Module

@Module
interface AccountsModule {

    @Binds
    @ModuleScope
    fun bindAccountsApi(impl: AccountsApiImpl): AccountsApi

    @Binds
    @ModuleScope
    fun bindRouter(router: RouterImpl): Router
}