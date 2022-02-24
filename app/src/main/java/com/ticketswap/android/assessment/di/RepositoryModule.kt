package com.ticketswap.android.assessment.di

import com.ticketswap.android.assessment.data.repository.BookAppointment
import com.ticketswap.android.assessment.data.repository.BookAppointmentImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindBookAppointment(bookAppointmentImpl: BookAppointmentImpl): BookAppointment
}
