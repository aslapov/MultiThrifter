package com.multithrifter.accounts.di

import com.multithrifter.accounts.AccountsApi
import com.multithrifter.accounts.AccountsDependencies
import com.multithrifter.accounts.presentation.ui.AccountsFragment
import com.multithrifter.core.di.CoreComponent
import com.multithrifter.core.di.ModuleScope
import dagger.Component

@ModuleScope
@Component(
    dependencies = [CoreComponent::class, AccountsDependencies::class],
    modules = [AccountsModule::class],
)
interface AccountsComponent {

    fun getApi(): AccountsApi

    fun inject(fragment: AccountsFragment)
}