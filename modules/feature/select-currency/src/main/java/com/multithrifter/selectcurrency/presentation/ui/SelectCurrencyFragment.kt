package com.multithrifter.selectcurrency.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.extensions.composeView
import com.multithrifter.core.extensions.getRequiredArgument
import com.multithrifter.core.view.CoreFragment
import com.multithrifter.selectcurrency.SelectCurrencyFeature
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyContract.SelectCurrencyEvent
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyContract.SelectCurrencyEvent.Initialize
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyContract.SelectCurrencyState
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyViewModel
import com.multithrifter.ui.MultiThrifterTheme

internal class SelectCurrencyFragment :
    CoreFragment<SelectCurrencyState, SelectCurrencyEvent, SelectCurrencyViewModel>() {

    companion object {
        private const val CURRENCY_KEY = "CURRENCY_KEY"

        fun newInstance(
            currency: Currency? = null,
        ): SelectCurrencyFragment = SelectCurrencyFragment().apply {
            currency?.let { currency ->
                arguments = bundleOf(CURRENCY_KEY to currency)
            }
        }
    }

    override val viewModel: SelectCurrencyViewModel by viewModels { viewModelFactory }

    override fun setupInjection() = SelectCurrencyFeature.inject(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.handleEvent(Initialize(getRequiredArgument(CURRENCY_KEY)))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return composeView {
            MultiThrifterTheme {
                SelectCurrencyScreen(
                    state = viewModel.uiState.collectAsState().value,
                    onEvent = viewModel::handleEvent,
                )
            }
        }
    }

    override fun onFinalDestroy() {
        SelectCurrencyFeature.destroyComponent()
        super.onFinalDestroy()
    }
}