package com.example.municipalapp.feature_business.presesntation.add_business

/**
 * Created by Stephen Obeng Takyi on 11/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
sealed class AddBusinessEvent {
    data class EnteredOwner(val value: String): AddBusinessEvent()
    data class EnteredMobileNumber(val value: String): AddBusinessEvent()
    data class SelectedOwnerType(val value: String): AddBusinessEvent()
    data class EnteredNameOfBusiness(val value: String): AddBusinessEvent()
    data class SelectedTypeOfBusiness(val value: String): AddBusinessEvent()
    data class SelectedPropertyOccupancyType(val value: String): AddBusinessEvent()
    data class SelectedElectoralArea(val value: String):AddBusinessEvent()
    data class EnteredLocation(val value: String):AddBusinessEvent()
    data class EnteredBusinessRegistrationNumber(val value: String):AddBusinessEvent()
    data class SelectedDateOfCommencement(val value: String):AddBusinessEvent()
    data class EnteredLandmark(val value: String):AddBusinessEvent()
    data class EnteredGPSCode(val value: String):AddBusinessEvent()
    data class EnteredLongitude(val value: String):AddBusinessEvent()
    data class EnteredLatitude(val value: String):AddBusinessEvent()
    data class EnteredEmail(val value: String):AddBusinessEvent()
    data class EnteredPostalAddress(val value: String):AddBusinessEvent()
    data class EnteredStreetName(val value: String):AddBusinessEvent()
    data class SelectedCategory(val value: String):AddBusinessEvent()
    data class SelectedSubCategory(val value: String):AddBusinessEvent()
    data class SelectedThirdCategory(val value: String):AddBusinessEvent()
    data class SelectedElectricityConnected(val value: String):AddBusinessEvent()
    data class SelectedTypeOfWaste(val value: String):AddBusinessEvent()
    data class EnteredRegistrationOfficer(val value: String):AddBusinessEvent()
    data class EnteredRegistrationAmount(val value: String):AddBusinessEvent()
    object SaveBusiness:AddBusinessEvent()

}