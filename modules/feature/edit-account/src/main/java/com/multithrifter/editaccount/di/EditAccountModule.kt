package com.multithrifter.editaccount.di

import androidx.lifecycle.ViewModel
import com.multithrifter.core.di.ModuleScope
import com.multithrifter.core.di.ViewModelKey
import com.multithrifter.core.di.ViewModelModule
import com.multithrifter.editaccount.EditAccountApi
import com.multithrifter.editaccount.EditAccountApiImpl
import com.multithrifter.editaccount.data.repo.EditAccountRepositoryImpl
import com.multithrifter.editaccount.domain.interactor.EditAccountInteractor
import com.multithrifter.editaccount.domain.interactor.EditAccountInteractorImpl
import com.multithrifter.editaccount.domain.repo.EditAccountRepository
import com.multithrifter.editaccount.presentation.navigation.Router
import com.multithrifter.editaccount.presentation.navigation.RouterImpl
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
internal interface EditAccountModule {

    @Binds
    @ModuleScope
    fun bindEditAccountApi(api: EditAccountApiImpl): EditAccountApi

    @Binds
    @ModuleScope
    fun bindRouter(router: RouterImpl): Router

    @Binds
    @IntoMap
    @ViewModelKey(EditAccountViewModel::class)
    fun bindViewModel(viewModel: EditAccountViewModel): ViewModel

    @Binds
    @ModuleScope
    fun bindInteractor(interactor: EditAccountInteractorImpl): EditAccountInteractor

    @Binds
    @ModuleScope
    fun bindRepository(repository: EditAccountRepositoryImpl): EditAccountRepository
}