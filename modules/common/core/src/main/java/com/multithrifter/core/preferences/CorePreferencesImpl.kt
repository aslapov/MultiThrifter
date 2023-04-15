package com.multithrifter.core.preferences

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

internal class CorePreferencesImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : CorePreferences {

    companion object {
        const val FILE_NAME = "core_preferences_storage"
        const val UPDATE_RATES_DATE_KEY = "update_rates_date"
    }

    override fun setUpdateRatesDate(date: Long) {
        sharedPreferences.edit {
            putLong(UPDATE_RATES_DATE_KEY, date)
        }
    }

    override fun getUpdateRatesDate(): Long {
        return sharedPreferences.getLong(UPDATE_RATES_DATE_KEY, 0)
    }
}