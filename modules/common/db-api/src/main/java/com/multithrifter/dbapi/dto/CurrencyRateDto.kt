package com.multithrifter.dbapi.dto

data class CurrencyRateDto(
    val rate: Float,
    val date: Long,
    val sourceCurrencyId: String,
    val sourceCurrencyName: String,
    val sourceCurrencyShortName: String,
    val sourceCurrencySymbol: String,
    val targetCurrencyId: String,
    val targetCurrencyName: String,
    val targetCurrencyShortName: String,
    val targetCurrencySymbol: String,
)
