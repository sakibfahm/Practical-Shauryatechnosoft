package com.example.mypractical.data.repository

import com.example.mypractical.api.SafeAPIRequest
import com.example.mypractical.api.WebServiceInterface
import com.example.mypractical.data.db.dao.UserDao
import com.example.mypractical.data.db.table.UserTable
import com.example.mypractical.data.model.ImageListModel
import com.google.gson.JsonObject
import javax.inject.Inject

class HomeRepository  @Inject constructor(
    private val webServiceInterface: WebServiceInterface,
    private val userDao: UserDao
) : SafeAPIRequest() {

    suspend fun getImages(userId: Int): ImageListModel {
        return apiRequest {
            webServiceInterface.getImages(userId)
        }
    }

    suspend fun inserUser(data: UserTable) : Long {
        return userDao.insertUser(data)
    }

    suspend fun getUsers(): UserTable {
        val model = userDao.getUsers()
        return model
    }

}