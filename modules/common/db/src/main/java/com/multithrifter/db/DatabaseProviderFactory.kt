package com.multithrifter.db

import com.multithrifter.core.AppProvider
import com.multithrifter.dbapi.DatabaseProvider
import com.multithrifter.dbimpl.DaggerDatabaseComponent

object DatabaseProviderFactory {

    fun createDatabaseProvider(appProvider: AppProvider): DatabaseProvider {
        return DaggerDatabaseComponent.builder()
            .appProvider(appProvider)
            .build()
    }
}