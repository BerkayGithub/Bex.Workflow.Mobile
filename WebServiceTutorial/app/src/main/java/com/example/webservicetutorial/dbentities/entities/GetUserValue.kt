package com.example.webservicetutorial.dbentities.entities

data class GetUserValue (
    var Units: List<GetUserUnit>? = null,
    var ViewOrganization: Boolean? = null,
    var ApiKey: String? = null,
    var Title: String? = null,
    var IsStakeHolder: Boolean? = null,
    var ProfileImageUrl: String? = null,
    var Director: Director? = null,
    var OrganizationID: Int? = null,
    var OrganizationName: String? = null,
    var EmployeeStatus: String? = null,
    var Contact: Contact? = null,
    var FirstName: String? = null,
    var LastName: String? = null,
    var IsSuper: Boolean? = null,
    var IsExecutive: Boolean? = null,
    var Name: String? = null,
    var ID: Int?
)