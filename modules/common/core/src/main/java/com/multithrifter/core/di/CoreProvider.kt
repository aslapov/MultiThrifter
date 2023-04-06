package com.multithrifter.core.di

import android.content.Context
import com.multithrifter.core.navigation.GlobalNavigator

interface CoreProvider {
    fun provideApplicationContext(): Context
    fun provideNavigator(): GlobalNavigator
}