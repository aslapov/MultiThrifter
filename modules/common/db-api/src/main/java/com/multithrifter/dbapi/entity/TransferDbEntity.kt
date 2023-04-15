package com.multithrifter.dbapi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = TransferDbEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = AccountDbEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("from_account_id"),
        ),
        ForeignKey(
            entity = AccountDbEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("to_account_id"),
        ),
    ],
)
data class TransferDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val description: String,
    val date: Long,
    @ColumnInfo(name = "from_amount") val amountFrom: Float,
    @ColumnInfo(name = "to_amount") val amountTo: Float,
    @ColumnInfo(name = "from_account_id") val fromAccountId: Int,
    @ColumnInfo(name = "to_account_id") val toAccountId: Int,
) {

    companion object {
        const val TABLE_NAME = "transfers"
    }
}
