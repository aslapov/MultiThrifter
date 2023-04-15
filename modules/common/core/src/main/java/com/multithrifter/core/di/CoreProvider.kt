package com.multithrifter.core.di

import android.content.Context
import com.multithrifter.core.navigation.GlobalNavigator
import com.multithrifter.core.preferences.CorePreferences

interface CoreProvider {
    fun provideApplicationContext(): Context
    fun provideNavigator(): GlobalNavigator
    fun provideCorePreferences(): CorePreferences
}