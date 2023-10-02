package com.example.municipalapp.feature_business.presesntation.add_business

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.municipalapp.feature_business.domain.model.Business
import com.example.municipalapp.feature_business.domain.model.InvalidBusinessException
import com.example.municipalapp.feature_business.domain.use_case.AddBusinessUseCase
import com.example.municipalapp.feature_business.domain.use_case.BusinessUseCases
import com.example.municipalapp.feature_business.domain.use_case.GetBusinessUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import java.util.UUID
import javax.inject.Inject

/**
 * Created by Stephen Obeng Takyi on 11/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */

@HiltViewModel
class AddBusinessViewModel @Inject constructor(
    private val businessUseCases: BusinessUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _owner = mutableStateOf("")
    val owner: State<String> = _owner

    private val _phoneNumber = mutableStateOf("")
    val phoneNumber: State<String> = _phoneNumber

    private val _ownerTypeName = mutableStateOf("")
    val ownerTypeName: State<String> = _ownerTypeName
    val ownerTypeId: State<String> = mutableStateOf("")

    private val _businessPropertyCode = mutableStateOf("")
    val businessPropertyCode: State<String> = _businessPropertyCode

    private val _nameOfBusiness = mutableStateOf("")
    val nameOfBusiness: State<String> = _nameOfBusiness

    private val _typeOfBusinessName = mutableStateOf("")
    val typeOfBusinessName: State<String> = _typeOfBusinessName
    val typeOfBusinessId: State<String> = mutableStateOf("")

    private val _propertyOccupancyTypeName = mutableStateOf("")
    val propertyOccupancyTypeName: State<String> = _propertyOccupancyTypeName
    val propertyOccupancyTypeId: State<String> = mutableStateOf("")

    private val _municipalAssemblyName = mutableStateOf("")
    val municipalAssemblyName: State<String> = _municipalAssemblyName
    val municipalAssemblyId: State<String> = mutableStateOf("")

    private val _electoralAreaName = mutableStateOf("")
    val electoralAreaName: State<String> = _electoralAreaName
    val electoralAreaId: State<String> = mutableStateOf("")

    private val _businessLocation = mutableStateOf("")
    val businessLocation: State<String> = _businessLocation

    private val _businessRegistrationNumber = mutableStateOf("")
    val businessRegistrationNumber: State<String> = _businessRegistrationNumber

    private val _dateOfCommencement = mutableStateOf("")
    val dateOfCommencement: State<String> = _dateOfCommencement

    private val _landmark = mutableStateOf("")
    val landmark: State<String> = _landmark

    private val _gpsCode = mutableStateOf("")
    val gpsCode: State<String> = _gpsCode

    private val _longitude = mutableStateOf("")
    val longitude: State<String> = _longitude

    private val _latitude = mutableStateOf("")
    val latitude: State<String> = _latitude

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _postalAddress = mutableStateOf("")
    val postalAddress: State<String> = _postalAddress

    private val _streetName = mutableStateOf("")
    val streetName: State<String> = _streetName

    private val _category = mutableStateOf("")
    val category: State<String> = _category
    val categoryId: State<String> = mutableStateOf("")

    private val _subCategory = mutableStateOf("")
    val subCategory: State<String> = _subCategory
    val subCategoryId: State<String> = mutableStateOf("")

    private val _thirdCategoryName = mutableStateOf("")
    val thirdCategoryName: State<String> = _thirdCategoryName
    val thirdCategoryId: State<String> = mutableStateOf("")

    private val _typeOfWaste = mutableStateOf("")
    val typeOfWaste: State<String> = _typeOfWaste
    val typeOfWasteId: State<String> = mutableStateOf("")

    private val _electricityConnected = mutableStateOf("")
    val electricityConnected: State<String> = _electricityConnected

    private val _registrationOfficer = mutableStateOf("")
    val registrationOfficer: State<String> = _registrationOfficer

    private val _registrationAmount = mutableStateOf("")
    val registrationAmount: State<String> = _registrationAmount

    private val _registrationDate = mutableStateOf("")
    val registrationDate: State<String> = _registrationDate

    private val _bopCode = mutableStateOf("")
    val bopCode: State<String> = _bopCode

    private var selectedBusinessId: UUID? = null

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        savedStateHandle.get<UUID>("businessId")?.let { businessId ->
            {
                if (businessId != null) {
                    viewModelScope.launch {
                        businessUseCases.getBusiness(businessId)?.also { business ->
                            selectedBusinessId = businessId
                            _nameOfBusiness.value = business.businessName
                            _category.value = business.category.toString()
                            _bopCode.value = business.businessOperatingPermitCode
                            _registrationDate.value = business.createdAt.toString()
                            _registrationOfficer.value = business.createdBy
                        }
                    }
                }
            }
        }
    }

    sealed class UIEvent {
        data class ShowSnackBar(val message: String) : UIEvent()
        object SaveBusiness : UIEvent()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onEvent(event: AddBusinessEvent) {
        when (event) {
            is AddBusinessEvent.EnteredOwner -> {
                _owner.value = owner.value
            }

            is AddBusinessEvent.EnteredMobileNumber -> {
                _phoneNumber.value = phoneNumber.value
            }

            is AddBusinessEvent.SelectedOwnerType -> {
                _ownerTypeName.value = ownerTypeName.value
            }

            is AddBusinessEvent.EnteredNameOfBusiness -> {
                _nameOfBusiness.value = nameOfBusiness.value
            }

            is AddBusinessEvent.SelectedTypeOfBusiness -> {
                _typeOfBusinessName.value = typeOfBusinessName.value
            }

            is AddBusinessEvent.SelectedPropertyOccupancyType -> {
                _propertyOccupancyTypeName.value = propertyOccupancyTypeName.value
            }

            is AddBusinessEvent.SelectedElectoralArea -> {
                _electoralAreaName.value = electoralAreaName.value
            }

            is AddBusinessEvent.EnteredLocation -> {
                _businessLocation.value = businessLocation.value
            }

            is AddBusinessEvent.EnteredBusinessRegistrationNumber -> {
                _businessRegistrationNumber.value = businessRegistrationNumber.value
            }

            is AddBusinessEvent.SelectedDateOfCommencement -> {
                _dateOfCommencement.value = dateOfCommencement.value
            }

            is AddBusinessEvent.EnteredLandmark -> {
                _landmark.value = landmark.value
            }

            is AddBusinessEvent.EnteredGPSCode -> {
                _gpsCode.value = gpsCode.value
            }

            is AddBusinessEvent.EnteredLongitude -> {
                _longitude.value = longitude.value
            }

            is AddBusinessEvent.EnteredLatitude -> {
                _latitude.value = latitude.value
            }

            is AddBusinessEvent.EnteredEmail -> {
                _email.value = email.value
            }

            is AddBusinessEvent.EnteredPostalAddress -> {
                _postalAddress.value = postalAddress.value
            }

            is AddBusinessEvent.EnteredStreetName -> {
                _streetName.value = streetName.value
            }

            is AddBusinessEvent.SelectedCategory -> {
                _category.value = category.value
            }

            is AddBusinessEvent.SelectedSubCategory -> {
                _subCategory.value = subCategory.value
            }

            is AddBusinessEvent.SelectedThirdCategory -> {
                _thirdCategoryName.value = thirdCategoryName.value
            }

            is AddBusinessEvent.SelectedElectricityConnected -> {
                _electricityConnected.value = electricityConnected.value
            }

            is AddBusinessEvent.SelectedTypeOfWaste -> {
                _typeOfWaste.value = typeOfWaste.value
            }

            is AddBusinessEvent.EnteredRegistrationOfficer -> {
                _registrationOfficer.value = registrationOfficer.value
            }

            is AddBusinessEvent.EnteredRegistrationAmount -> {
                _registrationAmount.value = registrationAmount.value
            }

            is AddBusinessEvent.SaveBusiness -> {
                viewModelScope.launch {
                    try {
                        businessUseCases.addBusiness(
                            Business(
                                id = selectedBusinessId ?: UUID.randomUUID(),
                                businessName = _nameOfBusiness.value,
                                category = UUID.fromString(categoryId.value),
                                createdAt = ZonedDateTime.now(),
                                createdBy = _registrationOfficer.value,
                                businessOperatingPermitCode = "GHA"
                            )
                        )
                        _eventFlow.emit(UIEvent.SaveBusiness)
                    } catch (e: InvalidBusinessException) {
                        _eventFlow.emit(
                            UIEvent.ShowSnackBar(
                                message = e.message ?: "Something went wrong while saving Business"
                            )
                        )
                    }
                }
            }
        }
    }

}