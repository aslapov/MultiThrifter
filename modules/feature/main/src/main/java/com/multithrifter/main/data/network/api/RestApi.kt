package com.multithrifter.main.data.network.api

import com.multithrifter.main.data.network.dto.LatestCurrencyRatesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("latest")
    suspend fun getLatestCurrencyRates(
        @Query("base") targetCurrency: String,
        @Query("symbols") sourceCurrencies: String,
    ): LatestCurrencyRatesDto
}