package com.multithrifter.dbimpl

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.dbapi.DatabaseProvider
import dagger.Component

@DatabaseScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [DatabaseModule::class]
)
interface DatabaseComponent : DatabaseProvider