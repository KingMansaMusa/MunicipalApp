package com.example.municipalapp.feature_business.data.data_source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.municipalapp.feature_business.domain.model.Business
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/**
 * Created by Stephen Obeng Takyi on 04/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */

@Dao
interface BusinessDao {

    @Query("SELECT * FROM business")
    fun getAllBusinesses(): Flow<List<Business>>

    @Query("SELECT * FROM business WHERE id = :id")
    suspend fun getBusinessById(id: UUID): Business?

    @Upsert
    suspend fun insertBusiness(business: Business)

}