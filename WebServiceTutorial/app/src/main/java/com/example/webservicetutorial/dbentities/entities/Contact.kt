package com.example.webservicetutorial.dbentities.entities

data class Contact (
    var AddressBookID: Int?,
    var ContactType: ContactType?,
    var DisplayName: String?,
    var RelatedEntityType: String?,
    var RelatedEntityID: String?,
    var DefaultAddress: DefaultAddress?,
    var DefaultEmail: DefaultEmail?,
    var DefaultPhone: DefaultPhone?,
    var DefaultWebAddress: DefaultWebAddress?,
    var Name: String?,
    var ID:Int?
)