package com.multithrifter.main

import com.multithrifter.core.AppProvider
import com.multithrifter.dbapi.DatabaseProvider
import com.multithrifter.networkapi.NetworkProvider
import dagger.Component

@Component(
    dependencies = [AppProvider::class, DatabaseProvider::class, NetworkProvider::class]
)
interface MainComponent {

    fun inject(activity: MainActivity)
}