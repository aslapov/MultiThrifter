package com.multithrifter.core

import android.app.Application
import com.multithrifter.core.di.CoreComponent
import com.multithrifter.core.di.DaggerCoreComponent

open class CoreApplication : Application() {

    companion object {
        lateinit var app: CoreApplication
    }

    init {
        app = this
    }

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        setupDagger()
        super.onCreate()
    }

    private fun setupDagger() {
        if (::coreComponent.isInitialized) return
        coreComponent = DaggerCoreComponent
            .builder()
            .application(this)
            .build()
    }
}