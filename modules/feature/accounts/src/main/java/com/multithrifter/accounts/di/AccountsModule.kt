package com.multithrifter.accounts.di

import androidx.lifecycle.ViewModel
import com.multithrifter.accounts.AccountsApi
import com.multithrifter.accounts.AccountsApiImpl
import com.multithrifter.accounts.data.mapper.AccountMapper
import com.multithrifter.accounts.data.mapper.AccountMapperImpl
import com.multithrifter.accounts.data.mapper.CurrencyRateMapper
import com.multithrifter.accounts.data.mapper.CurrencyRateMapperImpl
import com.multithrifter.accounts.data.repo.AccountsRepositoryImpl
import com.multithrifter.accounts.domain.interactor.AccountsInteractor
import com.multithrifter.accounts.domain.interactor.AccountsInteractorImpl
import com.multithrifter.accounts.domain.repo.AccountsRepository
import com.multithrifter.accounts.presentation.navigation.Router
import com.multithrifter.accounts.presentation.navigation.RouterImpl
import com.multithrifter.accounts.presentation.viewmodel.AccountsViewModel
import com.multithrifter.core.di.ModuleScope
import com.multithrifter.core.di.ViewModelKey
import com.multithrifter.core.di.ViewModelModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
internal interface AccountsModule {

    @Binds
    @ModuleScope
    fun bindAccountsApi(impl: AccountsApiImpl): AccountsApi

    @Binds
    @ModuleScope
    fun bindRouter(router: RouterImpl): Router

    @Binds
    @ModuleScope
    fun bindRepository(repo: AccountsRepositoryImpl): AccountsRepository

    @Binds
    @ModuleScope
    fun bindInteractor(interactor: AccountsInteractorImpl): AccountsInteractor

    @Binds
    @IntoMap
    @ViewModelKey(AccountsViewModel::class)
    fun bindAccountsViewModel(viewModel: AccountsViewModel): ViewModel

    @Binds
    @ModuleScope
    fun bindCurrencyRateMapper(mapper: CurrencyRateMapperImpl): CurrencyRateMapper

    @Binds
    @ModuleScope
    fun bindAccountMapper(mapper: AccountMapperImpl): AccountMapper
}