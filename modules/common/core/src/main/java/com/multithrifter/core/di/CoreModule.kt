package com.multithrifter.core.di

import android.app.Application
import android.content.Context
import com.multithrifter.core.navigation.GlobalNavigator
import com.multithrifter.core.navigation.GlobalNavigatorImpl
import com.multithrifter.core.preferences.CorePreferences
import com.multithrifter.core.preferences.CorePreferencesImpl
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

        @Provides
        @Singleton
        fun provideCorePreferences(context: Context): CorePreferences {
            return CorePreferencesImpl(
                context.getSharedPreferences(CorePreferencesImpl.FILE_NAME, Context.MODE_PRIVATE)
            )
        }
    }

    @Binds
    @Singleton
    fun provideNavigator(navigator: GlobalNavigatorImpl): GlobalNavigator
}