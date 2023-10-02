package com.example.municipalapp.feature_business.domain.repository

import com.example.municipalapp.feature_business.domain.model.Business
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * Created by Stephen Obeng Takyi on 04/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
interface BusinessRepository {

    fun getAllBusiness(): Flow<List<Business>>

    suspend fun getBusinessById(id: UUID): Business?

    suspend fun insertBusiness(business: Business)
}