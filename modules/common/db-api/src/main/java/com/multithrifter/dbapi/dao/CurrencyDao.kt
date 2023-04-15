package com.multithrifter.dbapi.dao

import androidx.room.Dao
import androidx.room.Query
import com.multithrifter.dbapi.entity.CurrencyDbEntity

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM ${CurrencyDbEntity.TABLE_NAME}")
    suspend fun getCurrencies(): List<CurrencyDbEntity>
}