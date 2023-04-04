package com.multithrifter.dbimpl

import com.multithrifter.core.AppProvider
import com.multithrifter.dbapi.DatabaseProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class],
    modules = [DatabaseModule::class]
)
interface DatabaseComponent : DatabaseProvider