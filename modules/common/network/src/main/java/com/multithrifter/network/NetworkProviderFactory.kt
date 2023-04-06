package com.multithrifter.network

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.networkapi.NetworkProvider
import com.multithrifter.networkimpl.DaggerNetworkComponent

object NetworkProviderFactory {

    fun createNetworkProvider(coreComponent: CoreComponent): NetworkProvider {
        return DaggerNetworkComponent.builder()
            .coreComponent(coreComponent)
            .build()
    }
}