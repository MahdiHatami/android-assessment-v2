package com.ticketswap.android.assessment.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ticketswap.android.assessment.ViewModelFactory
import com.ticketswap.android.assessment.view.vaccinesList.VaccinesViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@InstallIn(SingletonComponent::class)
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(VaccinesViewModel::class)
    abstract fun bindVaccinesViewModel(viewModel: VaccinesViewModel): ViewModel
}
