package com.multithrifter.accounts.domain.entity

import com.multithrifter.core.domain.entity.Currency

data class TotalEntity(
    val amount: Float,
    val currency: Currency,
)
