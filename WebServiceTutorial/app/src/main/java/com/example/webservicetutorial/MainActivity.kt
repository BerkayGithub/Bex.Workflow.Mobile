package com.example.webservicetutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.lifecycle.ViewModelProvider
import com.example.webservicetutorial.addressBook.AddressBookFragment
import com.example.webservicetutorial.home.HomeFragment
import com.example.webservicetutorial.profile.ProfileFragment
import com.example.webservicetutorial.repository.WorkflowServiceRepository
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware, NavigationView.OnNavigationItemSelectedListener {

    override val kodein by kodein()
    private lateinit var viewModel: MainViewModel
    private val repository: WorkflowServiceRepository by instance()

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get<MainViewModel>(MainViewModel::class.java)
        viewModel.repository = repository
        viewModel.context = this

        viewModel.getDomain()

        toolbar.setTitleTextColor(resources.getColor(R.color.white))
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav_view.bringToFront()

        toggle = ActionBarDrawerToggle(this, drawerlayout, toolbar , R.string.open, R.string.close)
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.profil -> supportFragmentManager.beginTransaction().replace(R.id.main_frame, ProfileFragment()).commit()
                R.id.address -> supportFragmentManager.beginTransaction().replace(R.id.main_frame, AddressBookFragment()).commit()
            }
            true
        }

        supportFragmentManager.beginTransaction().replace(R.id.main_frame, HomeFragment()).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.profil -> supportFragmentManager.beginTransaction().replace(R.id.main_frame, ProfileFragment()).commit()
            R.id.address -> supportFragmentManager.beginTransaction().replace(R.id.main_frame, AddressBookFragment()).commit()
        }
        return true
    }
}
