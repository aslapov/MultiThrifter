package com.multithrifter.networkimpl

import com.multithrifter.core.AppProvider
import com.multithrifter.networkapi.NetworkProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class],
    modules = [NetworkModule::class]
)
interface NetworkComponent : NetworkProvider