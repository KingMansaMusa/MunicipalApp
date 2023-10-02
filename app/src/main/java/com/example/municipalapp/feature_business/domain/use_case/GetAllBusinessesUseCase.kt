package com.example.municipalapp.feature_business.domain.use_case

import com.example.municipalapp.feature_business.domain.model.Business
import com.example.municipalapp.feature_business.domain.repository.BusinessRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by Stephen Obeng Takyi on 04/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
class GetAllBusinessesUseCase(
    private val repository: BusinessRepository
) {

    operator fun invoke(
        search: String
    ): Flow<List<Business>> {
        return repository.getAllBusiness().map { businesses ->
            businesses.filter { it.businessName.lowercase().contains(search) }
        }
    }

}