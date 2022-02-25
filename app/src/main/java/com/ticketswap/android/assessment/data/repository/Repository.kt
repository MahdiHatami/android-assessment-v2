package com.ticketswap.android.assessment.data.repository

import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.domain.model.PageQueryResult
import com.ticketswap.android.assessment.domain.model.QueryResult

interface Repository {
    suspend fun bookAppointment(): QueryResult<Boolean>
    suspend fun getVaccines(): PageQueryResult<List<Vaccine>>
    suspend fun getVaccineById(id: Long): QueryResult<Vaccine>
}
