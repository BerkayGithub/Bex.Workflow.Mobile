package com.example.webservicetutorial.dbentities.entities

data class AuthorityModel (
    var SecurityManagerID: Int? = null,
    var SessionTimeOut: Int? = null,
    var DaysPasswordExpires: Int? = null,
    var DayRemindExpiry: Int? = null,
    var MinimumPasswordLength: Int? = null,
    var MinimumNumberCount: Int? = null,
    var MinimumLetterCount: Int? = null,
    var UpperOrLowerCase: Int? = null,
    var RequiresActivation: Int? = null,
    var ActivationValidityTime: Int? = null,
    var UseSystemLogin: Int? = null,
    var Name: String? = null,
    var ID: Int? = null
    )