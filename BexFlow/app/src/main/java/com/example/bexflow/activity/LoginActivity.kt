package com.example.bexflow.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.bexflow.R
import com.example.bexflow.`interface`.AuthInterface
import com.example.bexflow.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity(), AuthInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val model: LoginViewModel = ViewModelProvider(this).get<LoginViewModel>(LoginViewModel::class.java)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.vievmodel = model
        model.authlistener = this

    }

    override fun onStarted() {
        Toast.makeText(this,"Login Started",Toast.LENGTH_LONG).show()
    }

    override fun onSuccess() {
        Toast.makeText(this,"Login Successful!",Toast.LENGTH_LONG).show()
    }

    override fun onFailure(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}
