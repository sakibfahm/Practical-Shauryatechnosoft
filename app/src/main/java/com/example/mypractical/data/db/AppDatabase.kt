package com.example.mypractical.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mypractical.data.db.dao.UserDao
import com.example.mypractical.data.db.table.UserTable

@Database(
    entities = arrayOf(
        UserTable::class,),
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {
    abstract fun getUser(): UserDao
}