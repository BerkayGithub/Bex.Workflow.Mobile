package com.example.webservicetutorial.dbentities.entities

data class GetDomainValue (
    var AuthorityID: Int? = null,
    var AddressBookID: Int? = null,
    var ConfigurationManagerID: Int? = null,
    var OrganizationID: Int? = null,
    var CommunicationCenterID: Int? = null,
    var Authority: AuthorityModel? = null,
    var Location: String? = null,
    var IsValid: Boolean? = null,
    var ApiKey: String? = null,
    var Name: String? = null,
    var ID: Int? = null
)