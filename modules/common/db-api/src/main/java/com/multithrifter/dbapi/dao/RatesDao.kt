package com.multithrifter.dbapi.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Query
import com.multithrifter.dbapi.dto.CurrencyRateDto
import com.multithrifter.dbapi.entity.CurrencyDbEntity
import com.multithrifter.dbapi.entity.ExchangeRateDbEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RatesDao {

    @Transaction
    @Query(
        "SELECT " +
            "${ExchangeRateDbEntity.TABLE_NAME}.rate, " +
            "${ExchangeRateDbEntity.TABLE_NAME}.date, " +
            "source_currencies.id AS sourceCurrencyId, " +
            "source_currencies.name AS sourceCurrencyName, " +
            "source_currencies.short_name AS sourceCurrencyShortName, " +
            "source_currencies.symbol AS sourceCurrencySymbol, " +
            "target_currencies.id AS targetCurrencyId, " +
            "target_currencies.name AS targetCurrencyName, " +
            "target_currencies.short_name AS targetCurrencyShortName, " +
            "target_currencies.symbol AS targetCurrencySymbol " +
        "FROM ${ExchangeRateDbEntity.TABLE_NAME} " +
        "INNER JOIN ${CurrencyDbEntity.TABLE_NAME} AS source_currencies on ${ExchangeRateDbEntity.TABLE_NAME}.source_currency_id = source_currencies.id " +
        "INNER JOIN ${CurrencyDbEntity.TABLE_NAME} AS target_currencies on ${ExchangeRateDbEntity.TABLE_NAME}.target_currency_id = target_currencies.id " +
        "WHERE ${ExchangeRateDbEntity.TABLE_NAME}.date BETWEEN :from AND :to"
    )
    fun getCurrencyRatesByPeriod(from: Long, to: Long): Flow<List<CurrencyRateDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createExchangeRate(exchangeRate: ExchangeRateDbEntity)
}