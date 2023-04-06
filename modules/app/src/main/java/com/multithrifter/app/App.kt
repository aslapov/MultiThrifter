package com.multithrifter.app

import com.multithrifter.app.mediators.MediatorManager
import com.multithrifter.core.CoreApplication

class App : CoreApplication() {
    override fun onCreate() {
        MediatorManager.init()
        super.onCreate()
    }
}