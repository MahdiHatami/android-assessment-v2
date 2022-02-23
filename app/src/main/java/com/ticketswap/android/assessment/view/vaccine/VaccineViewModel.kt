package com.ticketswap.android.assessment

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * (fragment as VaccineFragment).confirmAppointment() is not lifecycle aware
 * It would be better choice to use StateFlow or LiveData to prevent:
 * 1- configuration changes such as orientation
 * 2- Avoiding background work
 */
class VaccineViewModel : ViewModel() {

    val bookAppointment = BookAppointmentImpl()

    fun bookAppointment(fragment: Fragment) {
        bookAppointment.bookAppointment()
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                (fragment as VaccineFragment).confirmAppointment()
            }, {})
    }
}