package com.example.municipalapp.feature_business.domain.use_case

import com.example.municipalapp.feature_business.domain.model.Business
import com.example.municipalapp.feature_business.domain.model.InvalidBusinessException
import com.example.municipalapp.feature_business.domain.repository.BusinessRepository
import kotlin.jvm.Throws

/**
 * Created by Stephen Obeng Takyi on 05/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
class AddBusinessUseCase(
    private val repository: BusinessRepository
) {

    @Throws(InvalidBusinessException::class)
    suspend operator fun invoke(business: Business) {

        if (business.businessName.isBlank()){
            throw InvalidBusinessException("Business Name cannot be blank")
        }

//        if (business.owner.isBlank()){
//            throw InvalidBusinessException("Owner cannot be blank")
//        }

        repository.insertBusiness(business)
    }

}