package com.example.municipalapp.feature_business.data.data_source

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.ZonedDateTime

/**
 * Created by Stephen Obeng Takyi on 06/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
class Converter {

    @TypeConverter
    fun fromLocalDate(date: LocalDate): String? {
        return date?.toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toLocalDate(date: String): LocalDate? {
        return LocalDate.parse(date)
    }

    @TypeConverter
    fun fromZonedDateTime(date: ZonedDateTime): String? {
        return date?.toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toZonedDateTime(date: String): ZonedDateTime? {
        return ZonedDateTime.parse(date)
    }
}