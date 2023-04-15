package com.multithrifter.core.view

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.multithrifter.core.viewmodel.CoreViewModel
import com.multithrifter.core.viewmodel.UiEvent
import com.multithrifter.core.viewmodel.UiState
import javax.inject.Inject

abstract class CoreFragment<S : UiState, E : UiEvent, VM : CoreViewModel<S, E>> : Fragment {

    constructor() : super()
    constructor(@LayoutRes layoutResID: Int) : super(layoutResID)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract val viewModel: VM

    private var isInstanceSaved = false

    protected open fun setupInjection() {}

    override fun onAttach(context: Context) {
        setupInjection()
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
        isInstanceSaved = false
    }

    override fun onStart() {
        super.onStart()
        isInstanceSaved = false
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        isInstanceSaved = true
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isRealDestroy()) {
            onFinalDestroy()
        }
    }

    /**
     * Метод, который вызывается только тогда, когда фрагмент удаляется со стека навигации.
     * Не будет вызываться при изменении конфигурации
     */
    open fun onFinalDestroy() {}

    private fun isRealDestroy(): Boolean {
        return when {
            activity?.isChangingConfigurations == true -> false
            activity?.isFinishing == true -> true
            else -> isRealRemoving()
        }
    }

    private fun isRealRemoving(): Boolean {
        return (isRemoving && !isInstanceSaved) ||
            ((parentFragment as? CoreFragment<*, *, *>)?.isRealRemoving() ?: false)
    }
}