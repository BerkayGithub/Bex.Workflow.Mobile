package com.example.webservicetutorial.listener

import com.example.webservicetutorial.dbentities.entities.User
import com.example.webservicetutorial.dbentities.entities.User2


interface AuthInterface {

    fun onStarted()
    fun onSuccess(user : User)
    fun onFailure(message : String)

}