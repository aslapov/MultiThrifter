package com.multithrifter.core.di

import androidx.lifecycle.ViewModelProvider
import com.multithrifter.core.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}