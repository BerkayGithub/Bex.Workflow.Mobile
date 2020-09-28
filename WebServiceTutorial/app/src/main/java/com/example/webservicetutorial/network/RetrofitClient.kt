package com.example.webservicetutorial.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val BASE_URL = "http://bexfatestv2service.saasteknoloji.com/"
    private var mInstance: RetrofitClient? = null
    private var retrofit: Retrofit? = null

    fun RetrofitClient() : Retrofit{
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit as Retrofit
    }

}