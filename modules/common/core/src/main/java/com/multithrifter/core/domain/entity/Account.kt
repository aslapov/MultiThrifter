package com.multithrifter.core.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Account(
    val name: String,
    val balance: Float,
    val currency: Currency,
    val id: Int = 0,
) : Parcelable
