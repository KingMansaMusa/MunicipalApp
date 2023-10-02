package com.example.municipalapp.feature_business.domain.model

import java.time.ZonedDateTime
import java.util.UUID

/**
 * Created by Stephen Obeng Takyi on 05/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
data class Payment(
    val businessId: UUID,
    val amountPaid: Double,
    val receivedBy: String,
    val dateReceived: ZonedDateTime
)
