package com.multithrifter.createaccount.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import com.multithrifter.core.extensions.composeView
import com.multithrifter.core.view.CoreFragment
import com.multithrifter.createaccount.CreateAccountFeature
import com.multithrifter.createaccount.presentation.viewmodel.CreateAccountContract.AccountEvent
import com.multithrifter.createaccount.presentation.viewmodel.CreateAccountContract.AccountState
import com.multithrifter.createaccount.presentation.viewmodel.CreateAccountViewModel
import com.multithrifter.ui.MultiThrifterTheme

internal class CreateAccountFragment : CoreFragment<AccountState, AccountEvent, CreateAccountViewModel>() {

    companion object {
        fun newInstance(): CreateAccountFragment = CreateAccountFragment()
    }

    override val viewModel: CreateAccountViewModel by viewModels { viewModelFactory }

    override fun setupInjection() = CreateAccountFeature.component().inject(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return composeView {
            MultiThrifterTheme {
                CreateAccountScreen(
                    state = viewModel.uiState.collectAsState().value,
                    onEvent = viewModel::handleEvent,
                )
            }
        }
    }

    override fun onFinalDestroy() {
        CreateAccountFeature.destroyComponent()
        super.onFinalDestroy()
    }
}