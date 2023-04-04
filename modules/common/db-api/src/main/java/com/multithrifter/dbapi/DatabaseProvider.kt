package com.multithrifter.dbapi

import com.multithrifter.dbapi.dao.AccountsDao

interface DatabaseProvider {
    fun provideDatabase(): MultiThrifterDatabaseContract
    fun provideAccountsDao(): AccountsDao
}