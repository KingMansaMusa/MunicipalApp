package com.example.municipalapp.feature_business.domain.use_case

import com.example.municipalapp.feature_business.domain.model.Business

/**
 * Created by Stephen Obeng Takyi on 05/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
data class BusinessUseCases(
    val getAllBusinesses: GetAllBusinessesUseCase,
    val getBusiness: GetBusinessUseCase,
    val addBusiness: AddBusinessUseCase
) {
}