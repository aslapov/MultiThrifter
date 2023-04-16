package com.multithrifter.dbapi.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Query
import com.multithrifter.dbapi.dto.ExchangeRateDto
import com.multithrifter.dbapi.entity.CurrencyDbEntity
import com.multithrifter.dbapi.entity.ExchangeRateDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RatesDao {

    @Transaction
    @Query(
        "SELECT " +
            "source_currencies.id AS sourceCurrencyId, " +
            "source_currencies.name AS sourceCurrencyName, " +
            "source_currencies.short_name AS sourceCurrencyShortName, " +
            "source_currencies.symbol AS sourceCurrencySymbol, " +
            "target_currencies.id AS targetCurrencyId, " +
            "target_currencies.name AS targetCurrencyName, " +
            "target_currencies.short_name AS targetCurrencyShortName, " +
            "target_currencies.symbol AS targetCurrencySymbol, " +
            "${ExchangeRateDbEntity.TABLE_NAME}.rate, " +
            "${ExchangeRateDbEntity.TABLE_NAME}.date " +
        "FROM ${ExchangeRateDbEntity.TABLE_NAME} " +
        "INNER JOIN " +
            "(SELECT " +
                "source_currency_id, " +
                "target_currency_id, " +
                "MAX(date) as max_date " +
            "FROM rates " +
            "WHERE target_currency_id IN (:currencyIds) AND source_currency_id IN (:currencyIds) " +
            "GROUP BY source_currency_id, target_currency_id) latest_rates " +
        "ON " +
            "rates.source_currency_id = latest_rates.source_currency_id " +
            "AND rates.target_currency_id = latest_rates.target_currency_id " +
            "AND rates.date = latest_rates.max_date " +
        "INNER JOIN ${CurrencyDbEntity.TABLE_NAME} AS source_currencies " +
        "ON ${ExchangeRateDbEntity.TABLE_NAME}.source_currency_id = source_currencies.id " +
        "INNER JOIN ${CurrencyDbEntity.TABLE_NAME} AS target_currencies " +
        "ON ${ExchangeRateDbEntity.TABLE_NAME}.target_currency_id = target_currencies.id"
    )
    fun getLatestExchangeRateGroups(currencyIds: Collection<String>): Flow<List<ExchangeRateDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createExchangeRate(exchangeRate: ExchangeRateDbEntity)
}