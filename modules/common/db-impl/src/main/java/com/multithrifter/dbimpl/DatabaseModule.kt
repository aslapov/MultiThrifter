package com.multithrifter.dbimpl

import android.content.Context
import androidx.room.Room
import com.multithrifter.dbapi.MultiThrifterDatabaseContract
import com.multithrifter.dbapi.dao.AccountsDao
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    private companion object {
        const val MULTI_THRIFTER_DATABASE_NAME = "MULTI_THRIFTER_DB"
    }

    @Provides
    @DatabaseScope
    fun provideAccountsDao(multiThrifterDatabaseContract: MultiThrifterDatabaseContract): AccountsDao {
        return multiThrifterDatabaseContract.accountsDao()
    }

    @Provides
    @DatabaseScope
    fun provideDatabase(context: Context): MultiThrifterDatabaseContract {
        return Room.databaseBuilder(
            context = context,
            klass = MultiThrifterDatabase::class.java,
            name = MULTI_THRIFTER_DATABASE_NAME,
        ).build()
    }
}