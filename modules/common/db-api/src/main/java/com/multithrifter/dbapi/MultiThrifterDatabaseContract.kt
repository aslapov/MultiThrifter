package com.multithrifter.dbapi

import com.multithrifter.dbapi.dao.AccountsDao
import com.multithrifter.dbapi.dao.CurrencyDao
import com.multithrifter.dbapi.dao.RatesDao

interface MultiThrifterDatabaseContract {
    fun accountsDao(): AccountsDao
    fun currencyDao(): CurrencyDao
    fun ratesDao(): RatesDao
}