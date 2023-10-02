package com.example.municipalapp.feature_business.presesntation.businesses

import com.example.municipalapp.feature_business.domain.model.Payment

/**
 * Created by Stephen Obeng Takyi on 05/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
sealed class BusinessesEvent{
    data class MakePayment(val payment: Payment): BusinessesEvent()
    data class SearchBusiness(val search: String): BusinessesEvent()
    object ToggleSearch: BusinessesEvent()
}
