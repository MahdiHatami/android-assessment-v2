package com.ticketswap.android.assessment.view.vaccinesList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.data.local.VaccineDatabase
import javax.inject.Inject

/**
 * Using DI could help cleaner and reusable codes
 */
class VaccinesViewModel @Inject constructor(database: VaccineDatabase) : ViewModel() {

    private val _vaccinesList = MutableLiveData<List<Vaccine>>()
    val vaccinesList: LiveData<List<Vaccine>> = _vaccinesList

    init {
        _vaccinesList.value = database.getVaccines()
    }
}