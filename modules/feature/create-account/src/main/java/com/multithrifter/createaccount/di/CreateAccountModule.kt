package com.multithrifter.createaccount.di

import androidx.lifecycle.ViewModel
import com.multithrifter.core.di.ModuleScope
import com.multithrifter.core.di.ViewModelKey
import com.multithrifter.core.di.ViewModelModule
import com.multithrifter.createaccount.CreateAccountApi
import com.multithrifter.createaccount.CreateAccountApiImpl
import com.multithrifter.createaccount.data.mapper.CurrencyMapper
import com.multithrifter.createaccount.data.mapper.CurrencyMapperImpl
import com.multithrifter.createaccount.data.repo.CreateAccountRepositoryImpl
import com.multithrifter.createaccount.domain.interactor.CreateAccountInteractor
import com.multithrifter.createaccount.domain.interactor.CreateAccountInteractorImpl
import com.multithrifter.createaccount.domain.repo.CreateAccountRepository
import com.multithrifter.createaccount.presentation.navigation.Router
import com.multithrifter.createaccount.presentation.navigation.RouterImpl
import com.multithrifter.createaccount.presentation.viewmodel.CreateAccountViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
internal interface CreateAccountModule {

    @Binds
    @ModuleScope
    fun bindCreateAccountApi(api: CreateAccountApiImpl): CreateAccountApi

    @Binds
    @ModuleScope
    fun bindRouter(router: RouterImpl): Router

    @Binds
    @IntoMap
    @ViewModelKey(CreateAccountViewModel::class)
    fun bindViewModel(viewModel: CreateAccountViewModel): ViewModel

    @Binds
    @ModuleScope
    fun bindInteractor(interactor: CreateAccountInteractorImpl): CreateAccountInteractor

    @Binds
    @ModuleScope
    fun bindRepository(repository: CreateAccountRepositoryImpl): CreateAccountRepository

    @Binds
    @ModuleScope
    fun bindCurrencyMapper(mapper: CurrencyMapperImpl): CurrencyMapper
}