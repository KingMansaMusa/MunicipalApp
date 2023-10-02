package com.example.municipalapp.feature_business.domain.use_case

import com.example.municipalapp.feature_business.domain.model.Business
import com.example.municipalapp.feature_business.domain.repository.BusinessRepository
import java.util.UUID

/**
 * Created by Stephen Obeng Takyi on 05/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
class GetBusinessUseCase(
    private val repository: BusinessRepository
) {

    suspend operator fun invoke(id: UUID): Business? {
        return repository.getBusinessById(id)
    }

}