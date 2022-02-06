package com.example.mypractical.ui.main

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.mypractical.MyApp
import com.example.mypractical.api.ApiExceptions
import com.example.mypractical.api.NoInternetException
import com.example.mypractical.api.WebServiceInterface
import com.example.mypractical.data.db.table.UserTable
import com.example.mypractical.data.model.ImageListModel
import com.example.mypractical.data.repository.DairyPaging
import com.example.mypractical.data.repository.HomeRepository
import com.example.mypractical.utils.Coroutines
import com.google.gson.JsonObject
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val application: MyApp,
    private val webServiceInterface: WebServiceInterface,
    private val repository: HomeRepository
)  : AndroidViewModel(application)  {

    private val _query = MutableLiveData<String>("")

    val list = _query.switchMap {_query ->
        Pager(PagingConfig(pageSize = 20)) {
            DairyPaging(webServiceInterface)
        }.liveData.cachedIn(viewModelScope)
    }

    private val _imageList: MutableLiveData<ImageListModel> =
        MutableLiveData<ImageListModel>()
    val imageList: LiveData<ImageListModel>
        get() = _imageList

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError


    init {
        getImages(75)
    }

    fun getImages(userId : Int): LiveData<ImageListModel> {
        Coroutines.main {
            try {
                val apiResponse = repository.getImages(userId)
                _imageList.postValue(apiResponse)
            } catch (e: ApiExceptions) {
                _onMessageError.postValue(e.message)
            } catch (e: NoInternetException) {
                _onMessageError.postValue(e.message)
            }
        }
        return _imageList
    }

    suspend fun insertTopic(data: UserTable) {
        Coroutines.io {
            repository.inserUser(data)
        }
    }

    suspend fun getUsers(): UserTable {
        val model = repository.getUsers()
        return model
    }

}