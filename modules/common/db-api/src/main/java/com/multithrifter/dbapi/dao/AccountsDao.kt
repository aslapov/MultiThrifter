package com.multithrifter.dbapi.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Update
import com.multithrifter.dbapi.dto.AccountDbEntity
import com.multithrifter.dbapi.dto.AccountDto
import com.multithrifter.dbapi.dto.Currency
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountsDao {

    @Transaction
    @Query(
        "SELECT " +
            "${AccountDbEntity.TABLE_NAME}.id, " +
            "${AccountDbEntity.TABLE_NAME}.name, " +
            "${AccountDbEntity.TABLE_NAME}.balance, " +
            "${Currency.TABLE_NAME}.id AS currencyId, " +
            "${Currency.TABLE_NAME}.name AS currencyName, " +
            "${Currency.TABLE_NAME}.symbol AS currencySymbol " +
        "FROM ${AccountDbEntity.TABLE_NAME} " +
        "INNER JOIN ${Currency.TABLE_NAME} on ${AccountDbEntity.TABLE_NAME}.currency_id = ${Currency.TABLE_NAME}.id"
    )
    fun getAccounts(): Flow<List<AccountDto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createAccount(account: AccountDbEntity)

    @Update
    suspend fun updateAccount(account: AccountDbEntity)
}