package com.example.webservicetutorial.network

import com.example.webservicetutorial.dbentities.entities.User

data class SignInBody(
    val SessionID : Int,
    val AuthorityID : Int,
    val UserName : String,
    val Password : String,
    val LoginType : String
)