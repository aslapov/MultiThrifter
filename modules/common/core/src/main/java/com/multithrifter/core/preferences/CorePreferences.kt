package com.multithrifter.core.preferences

interface CorePreferences {
    fun setUpdateRatesDate(date: Long)
    fun getUpdateRatesDate(): Long
}