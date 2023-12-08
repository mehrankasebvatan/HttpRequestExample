package ir.mkv.httpexample.retrofit

import ir.mkv.httpexample.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    fun getList(): Call<MutableList<DataModel>>
}