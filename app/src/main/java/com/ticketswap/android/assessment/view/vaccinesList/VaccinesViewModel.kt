package com.ticketswap.android.assessment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Using DI could help cleaner and reusable codes
 */
class VaccinesViewModel : ViewModel() {

    private val database = VaccineDatabase()

    val vaccinesListMutable = MutableLiveData<List<Vaccine>>()
    val vaccinesList: LiveData<List<Vaccine>> = vaccinesListMutable

    init {
        vaccinesListMutable.value = database.getVaccines()
    }
}