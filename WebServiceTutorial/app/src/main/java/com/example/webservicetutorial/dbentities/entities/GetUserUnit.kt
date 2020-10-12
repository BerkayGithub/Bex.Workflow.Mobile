package com.example.webservicetutorial.dbentities.entities

data class GetUserUnit (
    var SecurityPermissionID : Int?,
    var OrganizationID : Int?,
    var Type : String?,
    var IsATemplate: Int?,
    var Template: Template?,
    var DirectorType: DirectorType?,
    var SubUnits: List<GetUserUnit>?,
    var FunctionalitiesInText: String?,
    var HierarchicalParentID: Int?,
    var HierarchicalParentName: String?,
    var SortOrder: String?,
    var HasSubRank: Boolean?,
    var Name: String?,
    var ID: Int?
)