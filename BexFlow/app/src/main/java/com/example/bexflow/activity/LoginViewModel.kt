package com.example.bexflow.activity

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.bexflow.`interface`.AuthInterface

class LoginViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null
    var authlistener: AuthInterface? = null

    fun validateLogin(view: View){
        //Take email and password input and open Main activity if they are correct.
        authlistener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authlistener?.onFailure("Invalid Email or Password.")
        }else {
            val intent = Intent(view.context , MainActivity::class.java)
            view.context.startActivity(intent)
            authlistener?.onSuccess()
        }
    }
}