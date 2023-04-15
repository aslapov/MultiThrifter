package com.multithrifter.dbapi

import com.multithrifter.dbapi.dao.AccountsDao
import com.multithrifter.dbapi.dao.CurrencyDao
import com.multithrifter.dbapi.dao.RatesDao

interface DatabaseProvider {
    fun provideDatabase(): MultiThrifterDatabaseContract
    fun provideAccountsDao(): AccountsDao
    fun provideCurrencyDao(): CurrencyDao
    fun provideRatesDao(): RatesDao
}