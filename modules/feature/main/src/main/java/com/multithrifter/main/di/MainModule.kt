package com.multithrifter.main.di

import androidx.lifecycle.ViewModel
import com.multithrifter.core.di.ModuleScope
import com.multithrifter.core.di.ViewModelKey
import com.multithrifter.core.di.ViewModelModule
import com.multithrifter.main.data.network.api.RestApi
import com.multithrifter.main.data.repo.MainRepositoryImpl
import com.multithrifter.main.domain.interactor.MainInteractor
import com.multithrifter.main.domain.interactor.MainInteractorImpl
import com.multithrifter.main.domain.repo.MainRepository
import com.multithrifter.main.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module(includes = [ViewModelModule::class])
internal interface MainModule {

    companion object {

        @Provides
        @ModuleScope
        fun provideRestApi(retrofit: Retrofit): RestApi {
            return retrofit.create(RestApi::class.java)
        }
    }

    @Binds
    @ModuleScope
    fun bindRepository(repository: MainRepositoryImpl): MainRepository

    @Binds
    @ModuleScope
    fun bindInteractor(repository: MainInteractorImpl): MainInteractor

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}