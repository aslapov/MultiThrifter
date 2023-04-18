package com.multithrifter.core.domain.entity

data class Account(
    val name: String,
    val balance: Float,
    val currency: Currency,
    val id: Int = 0,
)
