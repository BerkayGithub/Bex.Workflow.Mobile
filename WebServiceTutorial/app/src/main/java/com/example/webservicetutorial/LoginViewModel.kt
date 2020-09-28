package com.example.webservicetutorial

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.webservicetutorial.listener.AuthInterface
import com.example.webservicetutorial.network.MyAPI
import com.example.webservicetutorial.network.RetrofitClient
import com.example.webservicetutorial.network.RetrofitInstance
import com.example.webservicetutorial.network.SignInBody
import com.example.webservicetutorial.network.responses.AuthResponse
import com.example.webservicetutorial.repository.UserRepository
import com.example.webservicetutorial.util.Coroutines
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null
    var authlistener: AuthInterface? = null

    fun validateLogin(view: View){//Take email and password input and open Main activity if they are correct.
        authlistener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authlistener?.onFailure("Invalid Email or Password.")
            return
        }

        val retIn = RetrofitInstance.getRetrofitInstance().create(MyAPI::class.java)
        val signInInfo = SignInBody(0,0,email!!, password!!,"System")
        retIn.signin(signInInfo).enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                authlistener?.onFailure(t.message.toString())
            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 200) {
                    authlistener?.onSuccess()
                } else {
                    authlistener?.onFailure("Login Failed!")
                }
            }
        })

        /*Coroutines.main{
            val loginResponse = UserRepository().userLogin(email!!,password!!)
            if(loginResponse.isSuccessful){
                authlistener?.onSuccess(loginResponse.body()?.Value!!)
            }else{
                authlistener?.onFailure("Error Code : ${loginResponse.code()}")
            }
        }
         */

    }
}