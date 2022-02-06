package com.example.mypractical.api

import com.example.mypractical.data.model.ImageListModel
import com.example.mypractical.data.model.UserListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * REST API access points
 */
interface WebServiceInterface {

    @GET("GetCustomerRegisteredByApp_1_0")
    suspend fun getUserList(
        @Query("UserId")s: Int,
        @Query("PageNo")page: Int): Response<UserListModel>

    @GET("Sp_Get_Appimages_CA_1_0")
    suspend fun getImages(
        @Query("UserId")s: Int): Response<ImageListModel>

}