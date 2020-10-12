package com.example.webservicetutorial.repository

import com.example.webservicetutorial.network.MyAPI
import com.example.webservicetutorial.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String) : Response<AuthResponse> {
        return MyAPI().userlogin(0,0,email, password,"System")
    }
}