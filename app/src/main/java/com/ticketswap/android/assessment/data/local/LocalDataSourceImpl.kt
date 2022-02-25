package com.ticketswap.android.assessment.data.local

import com.ticketswap.android.assessment.data.local.db.VaccineDatabase
import com.ticketswap.android.assessment.data.model.Vaccine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

class LocalDataSourceImpl @Inject constructor(
    private val database: VaccineDatabase
) : LocalDataSource {
    override suspend fun getVaccines(): List<Vaccine> = withContext(Dispatchers.IO) {
        database.getVaccines()
    }

    override suspend fun getVaccine(vaccineId: Long): Vaccine = withContext(Dispatchers.IO) {
        database.getVaccine(vaccineId)
    }

    override suspend fun bookAppointment(): Boolean = withContext(Dispatchers.IO) {
        database.bookAppointment()
    }
}