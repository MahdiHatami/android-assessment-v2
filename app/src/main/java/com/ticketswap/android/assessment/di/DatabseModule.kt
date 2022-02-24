package com.ticketswap.android.assessment.di

import com.ticketswap.android.assessment.data.local.VaccineDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabseModule {

    @Singleton
    @Provides
    fun provideDatabase(): VaccineDatabase {
        return VaccineDatabase()
    }
}
