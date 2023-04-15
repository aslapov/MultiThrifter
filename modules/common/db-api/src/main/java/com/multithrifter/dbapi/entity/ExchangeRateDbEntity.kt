package com.multithrifter.dbapi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = ExchangeRateDbEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = CurrencyDbEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("source_currency_id"),
        ),
        ForeignKey(
            entity = CurrencyDbEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("target_currency_id"),
        ),
    ],
)
data class ExchangeRateDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val rate: Float,
    val date: Long,
    @ColumnInfo(name = "source_currency_id") val sourceCurrencyId: String,
    @ColumnInfo(name = "target_currency_id") val targetCurrencyId: String,
) {

    companion object {
        const val TABLE_NAME = "rates"
    }
}
