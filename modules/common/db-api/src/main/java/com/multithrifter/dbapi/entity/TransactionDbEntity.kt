package com.multithrifter.dbapi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = TransactionDbEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = AccountDbEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("account_id"),
        ),
        ForeignKey(
            entity = CategoryDbEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("category_id"),
        ),
    ],
)
data class TransactionDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val description: String,
    val amount: Float,
    val date: Long,
    @ColumnInfo(name = "account_id") val accountId: Int,
    @ColumnInfo(name = "category_id") val categoryId: Int,
) {

    companion object {
        const val TABLE_NAME = "transactions"
    }
}
