package com.example.webservicetutorial.network

import com.example.webservicetutorial.dbentities.entities.GetContactValue
import com.example.webservicetutorial.network.responses.GetContactResponse
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ContactServicesAPI {

    @FormUrlEncoded
    @POST("api/contact/contact/get")
    suspend fun getContact(
        @Header("Authorization") AuthorizationKey : String,
        @Field("AddressBookID") addressBookID : Int
    ) : Response<GetContactResponse>

    companion object{
        operator fun invoke() : ContactServicesAPI{
            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl("http://bexfatestv2service.saasteknoloji.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ContactServicesAPI::class.java)
        }
    }
}