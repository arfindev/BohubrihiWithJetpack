package com.example.bohubrihiwithjetpack.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private var retrofit: Retrofit? = null

    private constructor() {
        val retrofitClient = OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
        val baseUrl = "http://dataservice.accuweather.com/"

        retrofit = Retrofit.Builder()
            .client(retrofitClient)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    companion object {
        var retrofitInstance: RetrofitClient? = null
        fun nullChecker(): RetrofitClient? {
            if (retrofitInstance == null) {
                retrofitInstance = RetrofitClient()
            }
            return retrofitInstance
        }

    }

    fun getApi(): ApiService? {
        return retrofit?.create(ApiService::class.java)

    }


}