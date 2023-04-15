package com.multithrifter.dbapi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CurrencyDbEntity.TABLE_NAME)
data class CurrencyDbEntity(
    @PrimaryKey val id: String,
    val name: String,
    @ColumnInfo(name = "short_name") val shortName: String,
    val symbol: String,
) {

    companion object {
        const val TABLE_NAME = "currencies"
    }
}
