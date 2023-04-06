package com.multithrifter.incomes.di

import com.multithrifter.core.di.ModuleScope
import com.multithrifter.incomes.IncomesApi
import com.multithrifter.incomes.IncomesApiImpl
import com.multithrifter.incomes.presentation.navigation.Router
import com.multithrifter.incomes.presentation.navigation.RouterImpl
import dagger.Binds
import dagger.Module

@Module
interface IncomesModule {

    @Binds
    @ModuleScope
    fun bindAccountsApi(impl: IncomesApiImpl): IncomesApi

    @Binds
    @ModuleScope
    fun bindRouter(router: RouterImpl): Router
}