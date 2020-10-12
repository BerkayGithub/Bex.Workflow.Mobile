package com.example.webservicetutorial.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.webservicetutorial.MainActivity
import com.example.webservicetutorial.R
import com.example.webservicetutorial.databinding.ActivityLoginBinding
import com.example.webservicetutorial.dbentities.entities.User
import com.example.webservicetutorial.dbentities.entities.User2
import com.example.webservicetutorial.listener.AuthInterface
import com.example.webservicetutorial.repository.UserRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), AuthInterface, KodeinAware {

    override val kodein by kodein()
    private val repository : UserRepository by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val model: LoginViewModel = ViewModelProvider(this).get<LoginViewModel>(LoginViewModel::class.java)
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewmodel = model
        model.authlistener = this
        model.repository = repository
    }

    override fun onStarted() {
        Toast.makeText(this,"Login Started", Toast.LENGTH_LONG).show()
    }

    override fun onSuccess(user: User) {
        Toast.makeText(this,"Login Successful", Toast.LENGTH_LONG).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onFailure(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }
}
