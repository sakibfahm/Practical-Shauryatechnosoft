package com.example.mypractical.api

import com.example.mypractical.utils.Constant
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeAPIRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.code() in 200..299) {
            return response.body()!!
        } else if (response.code() == Constant.UNAUTHORIZED_CODE) {
            //Todo: APi call response Check failer data with failer code
            val error = response.errorBody()?.string()
            val message = StringBuffer()
            error.let {
                try {
                    message.append("Error 401 UNAUTHORIZED CODE")
                } catch (e: JSONException) {

                }
                throw ApiExceptions(message.toString())
            }
        } else if (response.code() == Constant.INTERNAL_SERVER_ERROR_CODE) {
            //Todo: APi call response Check failer data with failer code
            val error = response.errorBody()?.string()
            // return response.errorBody()!!
            val message = StringBuffer()
            error.let {
                try {
                    message.append("Error 500 Internal Server Error")
                } catch (e: JSONException) {

                }
                throw ApiExceptions(message.toString())
            }
        } else if (response.code() == Constant.NO_DATA_FOUND_CODE) {
            //Todo: APi call response Check failer data with failer code
            val error = response.errorBody()?.string()
            val message = StringBuffer()
            error.let {
                try {
                    message.append("Error 404 Data Not Found")
                } catch (e: JSONException) {

                }
                throw ApiExceptions(message.toString())
            }
        } else if (response.code() == Constant.METHOD_NOT_ALLOW) {
            //Todo: APi call response Check failer data with failer code
            val error = response.errorBody()?.string()
            val message = StringBuffer()
            error.let {
                try {
                    message.append("405 Method Not Allowed")
                } catch (e: JSONException) {

                }
                throw ApiExceptions(message.toString())
            }
        } else {
            //Todo: APi call response Check failer data with failer code
            val error = response.errorBody()?.string()
            val message = StringBuffer()
            error.let {
                try {
                    message.append(JSONObject(it).getString(Constant.RESPONSE_MESSAGE))
                } catch (e: JSONException) {

                }
                throw ApiExceptions(message.toString())
            }
        }
    }

}