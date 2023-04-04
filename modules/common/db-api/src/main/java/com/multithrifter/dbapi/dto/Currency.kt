package com.multithrifter.dbapi.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Currency.TABLE_NAME)
data class Currency(
    @PrimaryKey val id: String,
    val name: String,
    @ColumnInfo(name = "short_name") val shortName: String,
    val symbol: String,
) {

    companion object {
        const val TABLE_NAME = "currencies"
    }
}
