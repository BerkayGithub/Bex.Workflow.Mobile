package com.example.webservicetutorial.dbentities.entities

data class User (
    var UserID: Int? = null,
    var DatePasswordChanged: String? = null,
    var ForceToChangePassword: Int? = null,
    var name: String? = null,
    var LoginType: String? = null,
    var UserName: String? = null,
    var isActive: Boolean? = null,
    var UserFirstName: String? = null,
    var UserLastName: String? = null,
    var ID: Int? = null
)