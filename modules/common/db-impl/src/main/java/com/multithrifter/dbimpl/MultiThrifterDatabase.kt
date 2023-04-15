package com.multithrifter.dbimpl

import androidx.room.Database
import androidx.room.RoomDatabase
import com.multithrifter.dbapi.MultiThrifterDatabaseContract
import com.multithrifter.dbapi.entity.AccountDbEntity
import com.multithrifter.dbapi.entity.CategoryDbEntity
import com.multithrifter.dbapi.entity.CurrencyDbEntity
import com.multithrifter.dbapi.entity.ExchangeRateDbEntity
import com.multithrifter.dbapi.entity.TransactionDbEntity
import com.multithrifter.dbapi.entity.TransferDbEntity

@Database(
    entities = [
        AccountDbEntity::class,
        CategoryDbEntity::class,
        CurrencyDbEntity::class,
        ExchangeRateDbEntity::class,
        TransactionDbEntity::class,
        TransferDbEntity::class,
    ],
    version = 1,
)
abstract class MultiThrifterDatabase : RoomDatabase(), MultiThrifterDatabaseContract