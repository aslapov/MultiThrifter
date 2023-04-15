package com.multithrifter.main.domain.interactor

internal interface MainInteractor {
    suspend fun updateCurrencyRates()
}