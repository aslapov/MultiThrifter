package com.multithrifter.app

import android.app.Application
import android.content.Context
import com.multithrifter.core.AppProvider

class App : Application(), AppProvider {

    override fun provideContext(): Context = applicationContext
}