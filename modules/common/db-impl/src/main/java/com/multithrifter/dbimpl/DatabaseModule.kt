package com.multithrifter.dbimpl

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.multithrifter.dbapi.MultiThrifterDatabaseContract
import com.multithrifter.dbapi.dao.AccountsDao
import com.multithrifter.dbapi.dao.CurrencyDao
import com.multithrifter.dbapi.dao.RatesDao
import com.multithrifter.dbapi.entity.AccountDbEntity
import com.multithrifter.dbapi.entity.CurrencyDbEntity
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
    fun provideCurrencyDao(multiThrifterDatabaseContract: MultiThrifterDatabaseContract): CurrencyDao {
        return multiThrifterDatabaseContract.currencyDao()
    }

    @Provides
    @DatabaseScope
    fun provideRatesDao(multiThrifterDatabaseContract: MultiThrifterDatabaseContract): RatesDao {
        return multiThrifterDatabaseContract.ratesDao()
    }

    @Provides
    @DatabaseScope
    fun provideDatabase(context: Context): MultiThrifterDatabaseContract {
        return Room.databaseBuilder(
            context = context,
            klass = MultiThrifterDatabase::class.java,
            name = MULTI_THRIFTER_DATABASE_NAME,
        )
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    prepopulateDatabase(db)
                }
            })
            .build()
    }

    private fun prepopulateDatabase(db: SupportSQLiteDatabase) {
        db.execSQL("INSERT INTO ${CurrencyDbEntity.TABLE_NAME} VALUES ('RUB', 'российский рубль', 'рубль', '₽')")
        db.execSQL("INSERT INTO ${CurrencyDbEntity.TABLE_NAME} VALUES ('USD', 'доллар США', 'доллар', '$')")
        db.execSQL("INSERT INTO ${CurrencyDbEntity.TABLE_NAME} VALUES ('EUR', 'евро', 'евро', '€')")
        db.execSQL("INSERT INTO ${CurrencyDbEntity.TABLE_NAME} VALUES ('GEL', 'грузинский лари', 'лари', '₾')")

        db.execSQL("INSERT INTO ${AccountDbEntity.TABLE_NAME} VALUES (0, 'Мои деньги', 0f, 'RUB')")
    }
}