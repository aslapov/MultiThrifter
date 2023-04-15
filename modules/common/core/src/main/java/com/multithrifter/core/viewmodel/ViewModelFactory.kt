package com.multithrifter.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = providers[modelClass]
            ?: providers.asIterable().find { modelClass.isAssignableFrom(it.key) }?.value

        requireNotNull(provider) { "Unknown ViewModel class $modelClass" }

        @Suppress("UNCHECKED_CAST")
        return provider.get() as T
    }
}