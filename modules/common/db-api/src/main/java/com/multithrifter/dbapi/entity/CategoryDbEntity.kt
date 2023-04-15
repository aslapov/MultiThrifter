package com.multithrifter.dbapi.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = CategoryDbEntity.TABLE_NAME)
data class CategoryDbEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val type: Int,
    val icon: String,
    val color: String,
) {

    companion object {
        const val TABLE_NAME = "categories"
    }
}
