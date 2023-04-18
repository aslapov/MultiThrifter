package com.multithrifter.core.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Currency(
    val id: String,
    val name: String,
    val shortName: String,
    val symbol: String,
) : Parcelable {
    companion object {
        fun default() = Currency("RUB", "российский рубль", "рубль", "₽")
    }
}
