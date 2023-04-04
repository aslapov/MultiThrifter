package com.multithrifter.dbapi

import com.multithrifter.dbapi.dao.AccountsDao

interface MultiThrifterDatabaseContract {
    fun accountsDao(): AccountsDao
}