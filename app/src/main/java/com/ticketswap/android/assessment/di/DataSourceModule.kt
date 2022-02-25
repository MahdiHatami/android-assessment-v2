package com.ticketswap.android.assessment.di

import com.ticketswap.android.assessment.data.local.LocalDataSource
import com.ticketswap.android.assessment.data.local.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindDataSourceModule(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}