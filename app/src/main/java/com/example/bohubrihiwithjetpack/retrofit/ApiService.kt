package com.example.bohubrihiwithjetpack.retrofit

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("locations/v1/regions")
    fun getRegions(
        @Query("apikey") apiKey: String
    ): Call<ResponseBody>
}