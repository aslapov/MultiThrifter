package com.multithrifter.core.domain.entity

import java.util.*

data class ExchangeRate(
    val rate: Float,
    val date: Date,
    val sourceCurrency: Currency,
    val targetCurrency: Currency,
)
