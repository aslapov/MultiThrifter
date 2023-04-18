package com.multithrifter.core.domain.entity

data class Currency(
    val id: String,
    val name: String,
    val shortName: String,
    val symbol: String,
) {
    companion object {
        fun default() = Currency("RUB", "российский рубль", "рубль", "₽")
    }
}
