package com.example.municipalapp.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.municipalapp.feature_business.data.data_source.BusinessDao
import com.example.municipalapp.feature_business.data.data_source.BusinessDatabase
import com.example.municipalapp.feature_business.data.repository.BusinessRepositoryImpl
import com.example.municipalapp.feature_business.domain.repository.BusinessRepository
import com.example.municipalapp.feature_business.domain.use_case.AddBusinessUseCase
import com.example.municipalapp.feature_business.domain.use_case.BusinessUseCases
import com.example.municipalapp.feature_business.domain.use_case.GetAllBusinessesUseCase
import com.example.municipalapp.feature_business.domain.use_case.GetBusinessUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Stephen Obeng Takyi on 05/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesBusinessDatabase(app: Application): BusinessDatabase {
        return Room.databaseBuilder(
            app,
            BusinessDatabase::class.java,
            BusinessDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideBusinessRepository(db: BusinessDatabase): BusinessRepository {
        return BusinessRepositoryImpl(db.businessDao)
    }

    @Provides
    @Singleton
    fun provideBusinessUseCases(repository: BusinessRepository): BusinessUseCases {
        return BusinessUseCases(
            getAllBusinesses = GetAllBusinessesUseCase(repository),
            getBusiness = GetBusinessUseCase(repository),
            addBusiness = AddBusinessUseCase(repository)
        )
    }

}

