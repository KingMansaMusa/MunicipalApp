package com.example.municipalapp.feature_business.data.repository

import com.example.municipalapp.feature_business.data.data_source.BusinessDao
import com.example.municipalapp.feature_business.domain.model.Business
import com.example.municipalapp.feature_business.domain.repository.BusinessRepository
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * Created by Stephen Obeng Takyi on 04/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
class BusinessRepositoryImpl(
    private val dao: BusinessDao
) : BusinessRepository {

    override fun getAllBusiness(): Flow<List<Business>> {
        return dao.getAllBusinesses()
    }

    override suspend fun getBusinessById(id: UUID): Business? {
        return dao.getBusinessById(id)
    }

    override suspend fun insertBusiness(business: Business) {
        dao.insertBusiness(business)
    }
}