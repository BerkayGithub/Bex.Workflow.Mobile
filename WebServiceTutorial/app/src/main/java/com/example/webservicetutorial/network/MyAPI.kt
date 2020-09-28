package com.example.webservicetutorial.network

import com.example.webservicetutorial.network.responses.AuthResponse
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

    @Headers("Content-Type:application/json")
    @POST("api/visa/session/authorizesession/")
    fun signin(@Body info: SignInBody): Callback<ResponseBody>

    /*
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
            return Retrofit.Builder()
                .baseUrl("http://bexfatestv2service.saasteknoloji.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAPI::class.java)
        }
    }
     */

}

class RetrofitInstance {
    companion object {
        val BASE_URL: String = "http://bexfatestv2service.saasteknoloji.com/"

        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}