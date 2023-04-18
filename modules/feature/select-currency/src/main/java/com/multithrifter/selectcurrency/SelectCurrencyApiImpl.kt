package com.multithrifter.selectcurrency

import com.multithrifter.core.domain.entity.Currency
import com.multithrifter.selectcurrency.presentation.navigation.Router
import javax.inject.Inject

internal class SelectCurrencyApiImpl @Inject constructor(
    private val router: Router,
): SelectCurrencyApi {

    override fun showSelectCurrencyScreen(currency: Currency?) {
        router.showSelectCurrencyScreen(currency)
    }
}