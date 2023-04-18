package com.multithrifter.db

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.dbapi.DatabaseProvider
import com.multithrifter.dbimpl.DaggerDatabaseComponent

object DatabaseProviderFactory {

    private var databaseProvider: DatabaseProvider? = null

    fun getDatabaseProvider(coreComponent: CoreComponent) = databaseProvider ?: run {
        databaseProvider = DaggerDatabaseComponent.builder()
            .coreComponent(coreComponent)
            .build()

        requireNotNull(databaseProvider)
    }
}