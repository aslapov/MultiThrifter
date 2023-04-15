package com.multithrifter.main.domain.repo

internal interface MainRepository {
    suspend fun updateCurrencyRates()
}