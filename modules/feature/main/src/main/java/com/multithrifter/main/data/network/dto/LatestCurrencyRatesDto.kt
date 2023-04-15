package com.multithrifter.main.data.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LatestCurrencyRatesDto(
    val response: CurrencyRatesResponseDto,
) {

    @Serializable
    data class CurrencyRatesResponseDto(
        val date: String,
        @SerialName("base") val targetCurrency: String,
        @SerialName("rates") val sourceCurrencyRates: Map<String, Float?>,
    )
}
