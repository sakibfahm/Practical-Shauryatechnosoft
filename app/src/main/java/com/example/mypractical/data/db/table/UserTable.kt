package com.example.mypractical.data.db.table


import androidx.annotation.Keep
import androidx.room.*

@Entity(
    tableName = "user_table"
)
@Keep
data class UserTable(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    @ColumnInfo(name = "data")
    val data: String,
)