package com.multithrifter.network

import com.multithrifter.core.AppProvider
import com.multithrifter.networkapi.NetworkProvider
import com.multithrifter.networkimpl.DaggerNetworkComponent

object NetworkProviderFactory {

    fun createNetworkProvider(appProvider: AppProvider): NetworkProvider {
        return DaggerNetworkComponent.builder()
            .appProvider(appProvider)
            .build()
    }
}