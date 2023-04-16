package com.multithrifter.dbapi.dto

data class ExchangeRateDto(
    val sourceCurrencyId: String,
    val sourceCurrencyName: String,
    val sourceCurrencyShortName: String,
    val sourceCurrencySymbol: String,
    val targetCurrencyId: String,
    val targetCurrencyName: String,
    val targetCurrencyShortName: String,
    val targetCurrencySymbol: String,
    val rate: Float,
    val date: Long,
)
