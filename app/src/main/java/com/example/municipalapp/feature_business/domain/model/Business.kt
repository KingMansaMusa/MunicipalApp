package com.example.municipalapp.feature_business.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.Date
import java.util.UUID

/**
 * Created by Stephen Obeng Takyi on 04/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */

@Entity
data class Business(

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
//    val owner: String,
//    val mobileNumber: String,
//    val businessPropertyCode: String,
    val businessName: String,
//    val businessType: UUID,
//    val propertyOccupancyType: UUID,
//    val municipalAssembly: UUID,
//    val electoralArea: UUID,
//    val location: String,
//    val businessRegistrationNumber: String,
//    val dateOfCommencement: LocalDate,
//    val landmark: String,
//    val digitalAddressCode: String,
//    val longitude: Double,
//    val latitude: Double,
//    val email: String,
//    val postalAddress: String,
//    val streetName: String,
    val category: UUID,
//    val subCategory: UUID,
//    val thirdLevelCategory: UUID,
//    val electricityConnected: Boolean,
//    val wasteType: UUID,
//    val registrationAmount: Double,
    val businessOperatingPermitCode: String,
    val createdBy: String,
    val createdAt: ZonedDateTime

)

class InvalidBusinessException(message: String): Exception(message)
