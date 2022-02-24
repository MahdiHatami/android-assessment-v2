package com.ticketswap.android.assessment.di

import com.ticketswap.android.assessment.data.repository.BookAppointment
import com.ticketswap.android.assessment.data.repository.BookAppointmentImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(bookAppointmentImpl: BookAppointmentImpl): BookAppointment
}
