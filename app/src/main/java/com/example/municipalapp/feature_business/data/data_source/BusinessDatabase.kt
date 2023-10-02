package com.example.municipalapp.feature_business.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.municipalapp.feature_business.domain.model.Business

/**
 * Created by Stephen Obeng Takyi on 04/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */

@Database(entities = [Business::class], version = 1)
@TypeConverters(Converter::class)
abstract class BusinessDatabase: RoomDatabase() {

    abstract val businessDao: BusinessDao

    companion object{
        const val DATABASE_NAME = "business_db"
    }

}