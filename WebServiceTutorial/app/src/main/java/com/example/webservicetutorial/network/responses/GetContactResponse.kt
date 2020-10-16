package com.example.webservicetutorial.network.responses

import com.example.webservicetutorial.dbentities.entities.GetContactValue
import com.example.webservicetutorial.dbentities.entities.GrouperResult

class GetContactResponse (
    val Value : List<GetContactValue>,
    val TotalRowsCount : Int,
    val CurrentPage : Int,
    val GrouperResults : List<GrouperResult>,
    val Result : Boolean,
    val Description : String,
    val Code : String
    )