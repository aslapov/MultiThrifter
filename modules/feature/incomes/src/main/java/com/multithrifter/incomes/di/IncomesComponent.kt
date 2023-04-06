package com.multithrifter.incomes.di

import com.multithrifter.core.di.CoreComponent
import com.multithrifter.core.di.ModuleScope
import com.multithrifter.incomes.IncomesApi
import com.multithrifter.incomes.IncomesDependencies
import com.multithrifter.incomes.presentation.ui.IncomesFragment
import dagger.Component

@ModuleScope
@Component(
    dependencies = [CoreComponent::class, IncomesDependencies::class],
    modules = [IncomesModule::class],
)
interface IncomesComponent {

    fun getApi(): IncomesApi

    fun inject(fragment: IncomesFragment)
}