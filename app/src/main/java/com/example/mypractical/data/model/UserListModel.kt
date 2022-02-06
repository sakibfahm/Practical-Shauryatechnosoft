package com.example.mypractical.data.model


import com.google.gson.annotations.SerializedName

data class UserListModel(
    @SerializedName("data")
    val `data`: String = "",
    @SerializedName("data1")
    val data1: List<Data1> = listOf(),
    @SerializedName("data2")
    val data2: List<Data2> = listOf()
) {
    data class Data1(
        @SerializedName("AadharNo")
        val aadharNo: String = "",
        @SerializedName("Address")
        val address: String = "",
        @SerializedName("BankAccountNo")
        val bankAccountNo: String = "",
        @SerializedName("BranchId")
        val branchId: Int = 0,
        @SerializedName("BuffaloAccountId")
        val buffaloAccountId: Int = 0,
        @SerializedName("CollectionTypeId")
        val collectionTypeId: Int = 0,
        @SerializedName("CowAccountId")
        val cowAccountId: Int = 0,
        @SerializedName("DistrictId")
        val districtId: Int = 0,
        @SerializedName("DistrictName")
        val districtName: String = "",
        @SerializedName("EmailId")
        val emailId: String = "",
        @SerializedName("FName")
        val fName: String = "",
        @SerializedName("Id")
        val id: Int = 0,
        @SerializedName("IsSynch")
        val isSynch: Int = 0,
        @SerializedName("LName")
        val lName: String = "",
        @SerializedName("MName")
        val mName: String = "",
        @SerializedName("MobileNo")
        val mobileNo: String = "",
        @SerializedName("Note")
        val note: String = "",
        @SerializedName("PanNo")
        val panNo: String = "",
        @SerializedName("PhoneNo")
        val phoneNo: String = "",
        @SerializedName("RFName")
        val rFName: String = "",
        @SerializedName("RLName")
        val rLName: String = "",
        @SerializedName("RMName")
        val rMName: String = "",
        @SerializedName("RateCardGroupId")
        val rateCardGroupId: Int = 0,
        @SerializedName("RouteId")
        val routeId: Int = 0,
        @SerializedName("RouteName")
        val routeName: String = "",
        @SerializedName("SrNo")
        val srNo: Int = 0,
        @SerializedName("StateId")
        val stateId: Int = 0,
        @SerializedName("StateName")
        val stateName: String = "",
        @SerializedName("TalukaId")
        val talukaId: Int = 0,
        @SerializedName("VillageId")
        val villageId: Int = 0,
        @SerializedName("VillageName")
        val villageName: String = ""
    )
    data class Data2(
        @SerializedName("PageNo")
        val pageNo: String = "",
        @SerializedName("TotalCount")
        val totalCount: Int = 0
    )}