package com.multithrifter.accounts.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.viewModels
import com.multithrifter.accounts.AccountsFeature
import com.multithrifter.accounts.presentation.viewmodel.AccountsContract.AccountsEvent
import com.multithrifter.accounts.presentation.viewmodel.AccountsContract.AccountsState
import com.multithrifter.accounts.presentation.viewmodel.AccountsViewModel
import com.multithrifter.core.extensions.composeView
import com.multithrifter.core.view.CoreFragment
import com.multithrifter.ui.MultiThrifterTheme

internal class AccountsFragment : CoreFragment<AccountsState, AccountsEvent, AccountsViewModel>() {

    companion object {
        fun newInstance(): AccountsFragment = AccountsFragment()
    }

    override val viewModel: AccountsViewModel by viewModels { viewModelFactory }

    override fun setupInjection() = AccountsFeature.component().inject(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return composeView {
            MultiThrifterTheme {
                AccountsScreen(
                    state = viewModel.uiState.collectAsState().value,
                    onClickCreateAccount = {},
                )
            }
        }
    }

    override fun onFinalDestroy() {
        AccountsFeature.destroyComponent()
        super.onFinalDestroy()
    }
}