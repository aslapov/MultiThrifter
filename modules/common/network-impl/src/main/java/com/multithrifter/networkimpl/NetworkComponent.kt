package com.multithrifter.networkimpl

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.networkapi.NetworkProvider
import dagger.Component

@NetworkScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [NetworkModule::class]
)
interface NetworkComponent : NetworkProvider