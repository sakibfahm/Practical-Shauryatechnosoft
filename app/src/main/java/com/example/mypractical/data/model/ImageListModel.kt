package com.example.mypractical.data.model


import com.google.gson.annotations.SerializedName

data class ImageListModel(
    @SerializedName("data")
    val `data`: String = "",
    @SerializedName("data1")
    val data1: List<Data1> = listOf()
) {
    data class Data1(
        @SerializedName("imagepath")
        val imagepath: String = ""
    )
}