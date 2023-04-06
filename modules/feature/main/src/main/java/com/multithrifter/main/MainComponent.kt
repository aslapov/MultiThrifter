package com.multithrifter.main

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.core.di.ModuleScope
import dagger.Component

@ModuleScope
@Component(dependencies = [CoreComponent::class, MainDependencies::class])
interface MainComponent {

    fun inject(activity: MainActivity)
}