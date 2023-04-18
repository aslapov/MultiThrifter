package com.multithrifter.selectcurrency.di

import androidx.lifecycle.ViewModel
import com.multithrifter.core.di.ModuleScope
import com.multithrifter.core.di.ViewModelKey
import com.multithrifter.core.di.ViewModelModule
import com.multithrifter.selectcurrency.SelectCurrencyApi
import com.multithrifter.selectcurrency.SelectCurrencyApiImpl
import com.multithrifter.selectcurrency.data.mapper.CurrencyMapper
import com.multithrifter.selectcurrency.data.mapper.CurrencyMapperImpl
import com.multithrifter.selectcurrency.data.repo.SelectCurrencyRepositoryImpl
import com.multithrifter.selectcurrency.domain.interactor.SelectCurrencyInteractor
import com.multithrifter.selectcurrency.domain.interactor.SelectCurrencyInteractorImpl
import com.multithrifter.selectcurrency.domain.repo.SelectCurrencyRepository
import com.multithrifter.selectcurrency.presentation.navigation.Router
import com.multithrifter.selectcurrency.presentation.navigation.RouterImpl
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
internal interface SelectCurrencyModule {

    @Binds
    @ModuleScope
    fun bindSelectCurrencyApi(api: SelectCurrencyApiImpl): SelectCurrencyApi

    @Binds
    @IntoMap
    @ViewModelKey(SelectCurrencyViewModel::class)
    fun bindSelectCurrencyViewModel(viewModel: SelectCurrencyViewModel): ViewModel

    @Binds
    @ModuleScope
    fun bindRouter(router: RouterImpl): Router

    @Binds
    @ModuleScope
    fun bindInteractor(interactor: SelectCurrencyInteractorImpl): SelectCurrencyInteractor

    @Binds
    @ModuleScope
    fun bindRepository(repository: SelectCurrencyRepositoryImpl): SelectCurrencyRepository

    @Binds
    @ModuleScope
    fun bindCurrencyMapper(mapper: CurrencyMapperImpl): CurrencyMapper
}