package com.multithrifter.main.data.repo

import android.util.Log
import com.multithrifter.core.extensions.isSameDate
import com.multithrifter.core.extensions.toDate
import com.multithrifter.core.preferences.CorePreferences
import com.multithrifter.dbapi.dao.CurrencyDao
import com.multithrifter.dbapi.dao.RatesDao
import com.multithrifter.dbapi.entity.ExchangeRateDbEntity
import com.multithrifter.main.data.network.api.RestApi
import com.multithrifter.main.domain.repo.MainRepository
import java.util.*
import javax.inject.Inject

internal class MainRepositoryImpl @Inject constructor(
    private val currencyDao: CurrencyDao,
    private val ratesDao: RatesDao,
    private val restApi: RestApi,
    private val preferences: CorePreferences,
) : MainRepository {

    override suspend fun updateCurrencyRates() {
        val lastTime = preferences.getUpdateRatesDate().toDate()
        val now = Date()

        if (!now.isSameDate(lastTime)) {
            Log.d("OLOLO", "OLOLO rates network request")
            val currencies = currencyDao.getCurrencies().map { it.id }.toSet()

            currencies.forEach { targetCurrencyId ->
                val sourceCurrencyIds = currencies - targetCurrencyId

                val rates = restApi.getLatestCurrencyRates(
                    targetCurrency = targetCurrencyId,
                    sourceCurrencies = sourceCurrencyIds.joinToString(","),
                ).response

                rates.sourceCurrencyRates.forEach { (sourceCurrencyId, rate) ->
                    rate?.let {
                        val rateDbEntity = ExchangeRateDbEntity(
                            rate = rate,
                            date = now.time,
                            sourceCurrencyId = sourceCurrencyId,
                            targetCurrencyId = targetCurrencyId,
                        )
                        ratesDao.createExchangeRate(rateDbEntity)
                    }
                }
            }

            preferences.setUpdateRatesDate(now.time)
        }
    }
}