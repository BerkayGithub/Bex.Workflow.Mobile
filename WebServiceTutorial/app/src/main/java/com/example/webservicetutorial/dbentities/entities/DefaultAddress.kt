package com.example.webservicetutorial.dbentities.entities

data class DefaultAddress (
    var ContactID: Int?,
    var Country: Country?,
    var County: County?,
    var State: State?,
    var City: City?,
    var Body: String?,
    var ZipCode: Int?,
    var Latitude: Int?,
    var Longitude: Int?,
    var Altitude: Int?,
    var Sensitivity: Int?,
    var DisplayBody: String?,
    var Priority: Int?,
    var MapUrl: String?,
    var ID: Int?
)