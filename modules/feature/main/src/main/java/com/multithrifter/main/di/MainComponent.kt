package com.multithrifter.main.di

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.core.di.ModuleScope
import com.multithrifter.dbapi.DatabaseProvider
import com.multithrifter.main.presentation.MainActivity
import com.multithrifter.main.MainDependencies
import com.multithrifter.networkapi.NetworkProvider
import dagger.Component

@ModuleScope
@Component(
    dependencies = [
        CoreComponent::class,
        MainDependencies::class,
        DatabaseProvider::class,
        NetworkProvider::class,
    ],
    modules = [MainModule::class],
)
interface MainComponent {

    fun inject(activity: MainActivity)
}