package com.multithrifter.dbimpl

import androidx.room.Database
import androidx.room.RoomDatabase
import com.multithrifter.dbapi.MultiThrifterDatabaseContract
import com.multithrifter.dbapi.dto.AccountDbEntity
import com.multithrifter.dbapi.dto.CategoryDto
import com.multithrifter.dbapi.dto.Currency
import com.multithrifter.dbapi.dto.ExchangeRateDto
import com.multithrifter.dbapi.dto.TransactionDto
import com.multithrifter.dbapi.dto.TransferDto

@Database(
    entities = [
        AccountDbEntity::class,
        CategoryDto::class,
        Currency::class,
        ExchangeRateDto::class,
        TransactionDto::class,
        TransferDto::class,
    ],
    version = 1,
)
abstract class MultiThrifterDatabase : RoomDatabase(), MultiThrifterDatabaseContract