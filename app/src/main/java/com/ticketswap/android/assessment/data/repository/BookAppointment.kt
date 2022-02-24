package com.ticketswap.android.assessment.data.repository

import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.domain.model.QueryResult
import io.reactivex.Single

interface BookAppointment {
    fun bookAppointment(): QueryResult<Single<Boolean>>
    fun getVaccineById(id: Long) : QueryResult<Vaccine>
}
