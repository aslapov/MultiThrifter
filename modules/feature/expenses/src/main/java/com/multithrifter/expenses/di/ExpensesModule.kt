package com.multithrifter.expenses.di

import com.multithrifter.core.di.ModuleScope
import com.multithrifter.expenses.ExpensesApi
import com.multithrifter.expenses.ExpensesApiImpl
import com.multithrifter.expenses.presentation.navigation.Router
import com.multithrifter.expenses.presentation.navigation.RouterImpl
import dagger.Binds
import dagger.Module

@Module
interface ExpensesModule {

    @Binds
    @ModuleScope
    fun bindAccountsApi(impl: ExpensesApiImpl): ExpensesApi

    @Binds
    @ModuleScope
    fun bindRouter(router: RouterImpl): Router
}