package com.multithrifter.dbapi.dto

data class AccountDto(
    val id: Int,
    val name: String,
    val balance: Float,
    val currencyId: String,
    val currencyName: String,
    val currencyShortName: String,
    val currencySymbol: String,
)