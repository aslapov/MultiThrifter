package com.multithrifter.db

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.dbapi.DatabaseProvider
import com.multithrifter.dbimpl.DaggerDatabaseComponent

object DatabaseProviderFactory {

    fun createDatabaseProvider(coreComponent: CoreComponent): DatabaseProvider {
        return DaggerDatabaseComponent.builder()
            .coreComponent(coreComponent)
            .build()
    }
}