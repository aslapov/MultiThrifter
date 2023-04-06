package com.multithrifter.dbapi.dto

data class AccountDto(
    val id: Int,
    val name: String,
    val balance: Float,
    val currencyId: String,
    val currencyName: String,
    val currencySymbol: String,
)
