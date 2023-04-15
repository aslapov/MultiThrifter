package com.multithrifter.dbapi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = AccountDbEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = CurrencyDbEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("currency_id"),
        ),
    ],
)
data class AccountDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val balance: Float,
    @ColumnInfo(name = "currency_id") val currencyId: String,
) {

    companion object {
        const val TABLE_NAME = "accounts"
    }
}