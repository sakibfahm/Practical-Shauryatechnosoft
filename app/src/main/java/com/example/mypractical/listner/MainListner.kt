package com.example.mypractical.listner

import com.example.mypractical.data.model.UserListModel

interface MainListner {
    fun saveToDatabase(model : UserListModel.Data1)
}