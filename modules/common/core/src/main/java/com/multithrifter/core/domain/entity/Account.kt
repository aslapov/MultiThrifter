package com.multithrifter.core.domain.entity

data class Account(
    val id: Int,
    val name: String,
    val balance: Float,
    val currency: Currency,
)
