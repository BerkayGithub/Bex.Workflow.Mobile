package com.example.webservicetutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.webservicetutorial.databinding.ActivityLoginBinding
import com.example.webservicetutorial.dbentities.entities.User
import com.example.webservicetutorial.dbentities.entities.User2
import com.example.webservicetutorial.listener.AuthInterface

class LoginActivity : AppCompatActivity(), AuthInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val model: LoginViewModel = ViewModelProvider(this).get<LoginViewModel>(LoginViewModel::class.java)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewmodel = model
        model.authlistener = this
    }

    override fun onStarted() {
        Toast.makeText(this,"Login Started", Toast.LENGTH_LONG).show()
    }

    override fun onSuccess() {
        Toast.makeText(this,"Login Successful", Toast.LENGTH_LONG).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onFailure(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }
}
