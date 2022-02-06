package com.example.mypractical.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mypractical.api.WebServiceInterface
import com.example.mypractical.data.model.UserListModel
import javax.inject.Inject

class DairyPaging @Inject constructor(
    private val webServiceInterface: WebServiceInterface)
    : PagingSource<Int,UserListModel.Data1>() {

    override fun getRefreshKey(state: PagingState<Int, UserListModel.Data1>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state?.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserListModel.Data1> {
        val pageNo = params.key?:1
         return try {
             val data = webServiceInterface.getUserList(75,pageNo)
             LoadResult.Page(
                 data = data.body()?.data1!!,
                 prevKey = if(pageNo == 1) null else pageNo-1,
                 nextKey = if(data.body()?.data1?.isEmpty()!!) null else pageNo +1
             )
         } catch (e: Exception){
             LoadResult.Error(e)
         }
    }
}