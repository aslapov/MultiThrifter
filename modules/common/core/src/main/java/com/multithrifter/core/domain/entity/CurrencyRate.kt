package com.multithrifter.core.domain.entity

import java.util.*

data class CurrencyRate(
    val rate: Float,
    val date: Date,
    val sourceCurrency: Currency,
    val targetCurrency: Currency,
)
