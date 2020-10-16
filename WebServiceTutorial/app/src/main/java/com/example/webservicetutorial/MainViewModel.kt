package com.example.webservicetutorial

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.webservicetutorial.MVVMApplication.Companion.UserID
import com.example.webservicetutorial.MVVMApplication.Companion.userAPIKey
import com.example.webservicetutorial.repository.WorkflowServiceRepository
import com.example.webservicetutorial.util.Coroutines

class MainViewModel : ViewModel() {
    var DomainApiKey: String? = null
    var DomainResult: Boolean? = null
    var repository: WorkflowServiceRepository? = null
    var context: Context? = null
    var userApiKey: String? = null

    fun getDomain(){
        Coroutines.main{
            val domainResponse = repository!!.getDomain("bexfatest.saasteknoloji.com")
            if(domainResponse.isSuccessful){
                if(domainResponse.body()?.Result == true){
                    DomainApiKey = domainResponse.body()?.Value?.ApiKey
                    DomainResult = domainResponse.body()?.Result
                    getUser()
                    //Toast.makeText(context, "ApiKey : $DomainApiKey", Toast.LENGTH_LONG).show()
                }else{
                    DomainResult = domainResponse.body()?.Result
                    Toast.makeText(context, "Error while getting the domain ApiKey!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun getUser(){
        Coroutines.main{
            val userResponse = repository!!.getUser("Bearer " + DomainApiKey!!, UserID!!)
            if (userResponse.isSuccessful){
                if(userResponse.body()?.Result == true) {
                    userApiKey = userResponse.body()?.Value?.ApiKey
                    userAPIKey = userApiKey
                    Toast.makeText(context, "User ApiKey is : $userApiKey", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context,"Error occured while getting the user api key!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}