package com.example.webservicetutorial.network

import com.example.webservicetutorial.network.responses.GetDomainResponse
import com.example.webservicetutorial.network.responses.GetUserResponse
import com.google.gson.GsonBuilder
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface WorkflowServiceAPI {

    @FormUrlEncoded
    @POST("api/bexworkflow/getdomain")
    suspend fun getDomain(
        @Field("Location") location : String
    ) : Response<GetDomainResponse>

    @FormUrlEncoded
    @POST("api/bexworkflow/getuser")
    suspend fun getUser(
        @Header("Authorization") AuthorizationKey : String,
        @Field("ID") id : Int
    ) : Response<GetUserResponse>

    companion object{
        operator fun invoke() : WorkflowServiceAPI{
            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl("http://bexfatestv2service.saasteknoloji.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(WorkflowServiceAPI::class.java)
        }
    }
}