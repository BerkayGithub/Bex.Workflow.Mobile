package com.example.webservicetutorial.network.responses

import com.example.webservicetutorial.dbentities.entities.GetUserValue

data class GetUserResponse (
    val Value: GetUserValue,
    val Result: Boolean?,
    val Description: String?,
    val Code: String?
)