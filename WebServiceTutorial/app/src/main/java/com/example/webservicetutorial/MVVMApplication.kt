package com.example.webservicetutorial

import android.app.Application
import com.example.webservicetutorial.repository.ContactServiceRepository
import com.example.webservicetutorial.repository.UserRepository
import com.example.webservicetutorial.repository.WorkflowServiceRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider


class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from provider { UserRepository() }
        bind() from provider { WorkflowServiceRepository() }
        bind() from provider { ContactServiceRepository() }
    }

    companion object{
        var userAPIKey : String? = null

        var UserID: Int? = null
        var username: String? = null
        var UserFirstName: String? = null
        var UserLastName: String? = null
    }
}