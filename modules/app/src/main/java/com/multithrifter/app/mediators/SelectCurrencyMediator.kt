package com.multithrifter.app.mediators

import androidx.annotation.MainThread
import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.selectcurrency.SelectCurrencyFeature
import kotlinx.coroutines.flow.MutableSharedFlow

class SelectCurrencyMediator {

    @MainThread
    fun getApi(selectedCurrencyListener: MutableSharedFlow<Currency>) =
        SelectCurrencyFeature.getApi(selectedCurrencyListener)
}