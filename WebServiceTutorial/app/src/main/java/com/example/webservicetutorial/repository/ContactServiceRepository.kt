package com.example.webservicetutorial.repository

import com.example.webservicetutorial.network.ContactServicesAPI
import com.example.webservicetutorial.network.responses.GetContactResponse
import retrofit2.Response

class ContactServiceRepository {

    suspend fun getContact(AuthorizationKey : String, AddressBookID : Int) : Response<GetContactResponse> {
        return ContactServicesAPI.invoke().getContact(AuthorizationKey, AddressBookID)
    }
}