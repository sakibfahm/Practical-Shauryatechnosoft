package com.example.mypractical.data.db.dao

import androidx.room.*
import com.example.mypractical.data.db.table.UserTable

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getUsers(): UserTable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(topic: UserTable) : Long

}