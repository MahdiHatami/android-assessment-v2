package com.ticketswap.android.assessment.data.local

import com.ticketswap.android.assessment.data.model.Vaccine

interface LocalDataSource {
    suspend fun getVaccines(): List<Vaccine>
    suspend fun getVaccine(vaccineId: Long): Vaccine
    suspend fun bookAppointment(): Boolean
}