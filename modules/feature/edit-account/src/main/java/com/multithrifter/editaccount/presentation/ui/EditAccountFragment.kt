package com.multithrifter.editaccount.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.multithrifter.core.domain.entity.Account
import com.multithrifter.core.extensions.composeView
import com.multithrifter.core.extensions.getRequiredArgument
import com.multithrifter.core.view.CoreFragment
import com.multithrifter.editaccount.EditAccountFeature
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountEvent.Initialize
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountContract.AccountState
import com.multithrifter.editaccount.presentation.viewmodel.EditAccountViewModel
import com.multithrifter.ui.MultiThrifterTheme

internal class EditAccountFragment : CoreFragment<AccountState, AccountEvent, EditAccountViewModel>() {

    companion object {
        private const val ACCOUNT_KEY = "ACCOUNT_KEY"

        fun newInstance(
            account: Account,
        ): EditAccountFragment = EditAccountFragment().apply {
            arguments = bundleOf(ACCOUNT_KEY to account)
        }
    }

    override val viewModel: EditAccountViewModel by viewModels { viewModelFactory }

    override fun setupInjection() = EditAccountFeature.component().inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.handleEvent(Initialize(getRequiredArgument(ACCOUNT_KEY)))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return composeView {
            MultiThrifterTheme {
                EditAccountScreen(
                    state = viewModel.uiState.collectAsState().value,
                    onEvent = viewModel::handleEvent,
                )
            }
        }
    }

    override fun onFinalDestroy() {
        EditAccountFeature.destroyComponent()
        super.onFinalDestroy()
    }
}