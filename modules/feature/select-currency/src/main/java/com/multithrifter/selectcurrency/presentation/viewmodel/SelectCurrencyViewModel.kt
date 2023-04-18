package com.multithrifter.selectcurrency.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.core.viewmodel.CoreViewModel
import com.multithrifter.selectcurrency.SelectedCurrencyListenerActions
import com.multithrifter.selectcurrency.domain.interactor.SelectCurrencyInteractor
import com.multithrifter.selectcurrency.presentation.navigation.Router
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyContract.SelectCurrencyEvent
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyContract.SelectCurrencyEvent.BackClicked
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyContract.SelectCurrencyEvent.CurrencySelected
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyContract.SelectCurrencyEvent.Initialize
import com.multithrifter.selectcurrency.presentation.viewmodel.SelectCurrencyContract.SelectCurrencyState
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class SelectCurrencyViewModel @Inject constructor(
    private val interactor: SelectCurrencyInteractor,
    private val router: Router,
    private val selectedCurrencyListenerActions: SelectedCurrencyListenerActions,
) : CoreViewModel<SelectCurrencyState, SelectCurrencyEvent>() {

    init {
        getCurrencies()
    }

    override fun createInitialState() = SelectCurrencyState()

    override fun handleEvent(event: SelectCurrencyEvent) {
        when (event) {
            is Initialize -> initialize(event.currency)
            is CurrencySelected -> currencySelected(event.currency)
            BackClicked -> navigateBack()
        }
    }

    private fun getCurrencies() {
        viewModelScope.launch {
            val currencies = interactor.getCurrencies()
            setState { copy(currencies = currencies) }
        }
    }

    private fun initialize(currency: Currency) {
        setState { copy(selectedCurrency = currency) }
    }

    private fun currencySelected(currency: Currency) {
        selectedCurrencyListenerActions.updateSelectedCurrency(currency)
        navigateBack()
    }

    private fun navigateBack() {
        router.onBack()
    }
}