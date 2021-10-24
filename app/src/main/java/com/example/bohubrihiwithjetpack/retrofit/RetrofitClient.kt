package com.example.bohubrihiwithjetpack.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private var retrofit: Retrofit? = null


    private constructor() {
        val clinetConnection = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        val baseUrl = "http://dataservice.accuweather.com/"

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(clinetConnection)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        var myInstance: RetrofitClient? = null
        fun getInstance(): RetrofitClient {
            if (myInstance == null)
                myInstance = RetrofitClient()
            return RetrofitClient()
        }
    }

    fun getApi(): ApiService? {
        return retrofit?.create(ApiService::class.java)
    }


}