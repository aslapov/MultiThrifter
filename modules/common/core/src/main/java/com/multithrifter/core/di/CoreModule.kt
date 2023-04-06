package com.multithrifter.core.di

import android.app.Application
import android.content.Context
import com.multithrifter.core.navigation.GlobalNavigator
import com.multithrifter.core.navigation.GlobalNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface CoreModule {

    companion object {

        @Provides
        @Singleton
        fun provideApplicationContext(application: Application): Context {
            return application.applicationContext
        }
    }

    @Binds
    @Singleton
    fun provideNavigator(navigator: GlobalNavigatorImpl): GlobalNavigator
}