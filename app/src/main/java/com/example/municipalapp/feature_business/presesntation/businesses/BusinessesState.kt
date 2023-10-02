package com.example.municipalapp.feature_business.presesntation.businesses

import com.example.municipalapp.feature_business.domain.model.Business

/**
 * Created by Stephen Obeng Takyi on 05/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
data class BusinessesState(
    val businesses: List<Business> = emptyList(),
    val search: String = "",
    val isSearchVisible: Boolean = false
)
