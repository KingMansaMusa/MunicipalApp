package com.example.municipalapp.feature_business.presesntation.businesses

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.municipalapp.feature_business.domain.use_case.BusinessUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Stephen Obeng Takyi on 05/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */

@HiltViewModel
class BusinessesViewModel @Inject constructor(
    private val businessUseCases: BusinessUseCases
) : ViewModel() {

    private var getBusinessJob: Job? = null
    private val _state = mutableStateOf(BusinessesState())
    val state: State<BusinessesState> = _state

    init {
        getAllBusinesses("" )
    }

    fun onEvent(event: BusinessesEvent) {
        when (event) {

            is BusinessesEvent.SearchBusiness -> {

                getAllBusinesses(_state.value.search)

            }

            is BusinessesEvent.MakePayment -> {

            }

            is BusinessesEvent.ToggleSearch -> {
                _state.value = state.value.copy(
                    isSearchVisible = !state.value.isSearchVisible
                )
            }
        }
    }


    private fun getAllBusinesses(search: String) {
        getBusinessJob?.cancel()
        getBusinessJob = businessUseCases.getAllBusinesses(search).onEach { businesses ->
            _state.value = state.value.copy(
                businesses = businesses
            )
        }
            .launchIn(viewModelScope)
    }

}