package com.example.webservicetutorial.network.responses

import com.example.webservicetutorial.dbentities.entities.GetDomainValue

data class GetDomainResponse(
    val Value: GetDomainValue?,
    val Result: Boolean?,
    val Description: String?,
    val Code: String?
)