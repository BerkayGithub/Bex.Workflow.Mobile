package com.example.webservicetutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.webservicetutorial.repository.WorkflowServiceRepository
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private lateinit var viewModel: MainViewModel
    private val repository: WorkflowServiceRepository by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get<MainViewModel>(MainViewModel::class.java)
        viewModel.repository = repository
        viewModel.context = this

        viewModel.getDomain()
    }
}
