package com.ticketswap.android.assessment.view.vaccinesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.data.repository.Repository
import com.ticketswap.android.assessment.domain.model.PageQueryResult
import com.ticketswap.android.assessment.view.mapper.toViewVaccineItem
import com.ticketswap.android.assessment.view.util.LoadingState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Using DI could help cleaner and reusable codes
 */
class VaccinesViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _loadingState: MutableStateFlow<LoadingState> = MutableStateFlow(LoadingState.None)
    val loadingState: StateFlow<LoadingState> = _loadingState

    private val _onError: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val onError: StateFlow<Boolean> = _onError

    private val _vaccinesList = MutableStateFlow<List<ViewVaccineItem>>(emptyList())
    val vaccinesList: StateFlow<List<ViewVaccineItem>> = _vaccinesList

    private val _selectedVaccine: Channel<Long> = Channel()
    val selectedVaccine: Flow<Long> = _selectedVaccine.receiveAsFlow()

    init {
        loadVaccines()
    }

    fun loadVaccines() {
        _loadingState.value = LoadingState.Loading
        viewModelScope.launch {
            when (val result = repository.getVaccines()) {
                is PageQueryResult.Successful -> {
                    _vaccinesList.value = result.data.toViewVaccineItems()
                }
                PageQueryResult.Error -> _onError.value = true
            }
            _loadingState.value = LoadingState.None
        }
    }

    private fun List<Vaccine>.toViewVaccineItems(): List<ViewVaccineItem> = map { vaccine ->
        vaccine.toViewVaccineItem {
            _selectedVaccine.trySend(vaccine.id)
        }
    }
}
