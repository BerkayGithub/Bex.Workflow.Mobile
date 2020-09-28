package com.example.webservicetutorial.network.responses

import com.example.webservicetutorial.dbentities.entities.User
import com.example.webservicetutorial.dbentities.entities.User2

data class AuthResponse(
    val Value : User?,
    val Result : Boolean?,
    val Description : String?,
    val Code : String?
)