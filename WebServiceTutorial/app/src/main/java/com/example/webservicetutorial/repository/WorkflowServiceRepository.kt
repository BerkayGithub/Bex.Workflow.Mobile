package com.example.webservicetutorial.repository

import com.example.webservicetutorial.network.WorkflowServiceAPI
import com.example.webservicetutorial.network.responses.GetDomainResponse
import com.example.webservicetutorial.network.responses.GetUserResponse
import retrofit2.Response

class WorkflowServiceRepository {
    suspend fun getDomain(Location: String) : Response<GetDomainResponse>{
        return WorkflowServiceAPI.invoke().getDomain(Location)
    }

    suspend fun getUser(AuthorizationKey: String, ID: Int) : Response<GetUserResponse>{
        return WorkflowServiceAPI.invoke().getUser(AuthorizationKey, ID)
    }
}