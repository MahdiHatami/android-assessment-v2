package com.ticketswap.android.assessment.view.vaccine

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.ticketswap.android.assessment.data.repository.BookAppointment
import com.ticketswap.android.assessment.domain.model.QueryResult
import com.ticketswap.android.assessment.view.mapper.toViewVaccineDetailItem
import com.ticketswap.android.assessment.view.mapper.toViewVaccineItem
import com.ticketswap.android.assessment.view.util.LoadingState
import com.ticketswap.android.assessment.view.vaccinesList.ViewVaccineItem
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * (fragment as VaccineFragment).confirmAppointment() is not lifecycle aware
 * It would be better choice to use StateFlow or LiveData to prevent:
 * 1- configuration changes such as orientation
 * 2- Avoiding background work
 */
class VaccineViewModel @Inject constructor(
    private val repository: BookAppointment
) : ViewModel() {

    private val _loadingState: MutableStateFlow<LoadingState> = MutableStateFlow(LoadingState.None)
    val loadingState: StateFlow<LoadingState> = _loadingState

    private val _onError: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val onError: StateFlow<Boolean> = _onError

    private val _confirmAppointment: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val confirmAppointment: StateFlow<Boolean> = _confirmAppointment

    private val _selectedVaccine: MutableStateFlow<ViewVaccineDetailItem?> = MutableStateFlow(null)
    val selectedVaccine: StateFlow<ViewVaccineDetailItem?> = _selectedVaccine

    @SuppressLint("CheckResult")
    fun bookAppointment() {
        _loadingState.value = LoadingState.Loading
        when (val result = repository.bookAppointment()) {
            is QueryResult.Successful -> {
                result.data
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        _confirmAppointment.value = true
                    }, {})
            }
            QueryResult.Error -> _onError.value = true
            else -> {
                _onError.value = true
            }
        }
    }

    fun loadVaccineDetail(vaccineId: Long) {
        _loadingState.value = LoadingState.Loading
        when (val result = repository.getVaccineById(vaccineId)) {
            is QueryResult.Successful -> {
                _selectedVaccine.value = result.data.toViewVaccineDetailItem()
            }
            QueryResult.Error -> _onError.value = true
            else -> {
                _onError.value = true
            }
        }
    }
}
