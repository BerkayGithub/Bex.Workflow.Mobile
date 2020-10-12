package com.example.webservicetutorial.network

import com.example.webservicetutorial.network.responses.AuthResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyAPI {

    @FormUrlEncoded
    @POST("api/visa/session/authorizesession/")
    suspend fun userlogin(
        @Field("SessionID") sessionID : Int,
        @Field("AuthorityID") authorityID : Int,
        @Field("UserName") email : String,
        @Field("Password") password : String,
        @Field("LoginType") loginType : String
    ) : Response<AuthResponse>

    companion object{
        operator fun invoke() : MyAPI{
            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl("http://bexfatestv2service.saasteknoloji.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(MyAPI::class.java)
        }
    }

}
