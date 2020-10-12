package com.example.webservicetutorial.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.webservicetutorial.MVVMApplication.Companion.UserFirstName
import com.example.webservicetutorial.MVVMApplication.Companion.UserID
import com.example.webservicetutorial.MVVMApplication.Companion.UserLastName
import com.example.webservicetutorial.MVVMApplication.Companion.username
import com.example.webservicetutorial.listener.AuthInterface
//import com.example.webservicetutorial.network.RetrofitInstance
import com.example.webservicetutorial.repository.UserRepository
import com.example.webservicetutorial.util.Coroutines

class LoginViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null
    var authlistener: AuthInterface? = null
    var repository: UserRepository? = null

    fun validateLogin(view: View){//Take email and password input and open Main activity if they are correct.
        authlistener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authlistener?.onFailure("Invalid Email or Password.")
            return
        }

        Coroutines.main{
            val loginResponse = repository!!.userLogin(email!!,password!!)
            if(loginResponse.isSuccessful){
                if(loginResponse.body()?.Result == true){
                    authlistener?.onSuccess(loginResponse.body()?.Value!!)
                    UserID = loginResponse.body()?.Value!!.UserID
                    username = loginResponse.body()?.Value!!.UserName
                    UserFirstName = loginResponse.body()?.Value!!.UserFirstName
                    UserLastName = loginResponse.body()?.Value!!.UserLastName
                }else{
                    authlistener?.onFailure("Invalid Username or Password!")
                }
            }else{
                authlistener?.onFailure("Error Code : ${loginResponse.code()}")
            }
        }

    }
}