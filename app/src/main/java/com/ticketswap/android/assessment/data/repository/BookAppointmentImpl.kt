package com.ticketswap.android.assessment.data.repository

import com.ticketswap.android.assessment.data.local.VaccineDatabase
import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.domain.model.QueryResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.random.Random

/**
 * Do not review this class, this is a mock implementation meant to simulate a real database.
 */
class BookAppointmentImpl @Inject constructor(
    private val database: VaccineDatabase
) : BookAppointment {
    override suspend fun bookAppointment(): QueryResult.Successful<Boolean> =
        withContext(Dispatchers.IO) {
            val random = Random.nextBoolean().also { delay(Random.nextLong() % 30L) }
            QueryResult.Successful(random)
        }

    override suspend fun getVaccineById(id: Long): QueryResult<Vaccine> =
        withContext(Dispatchers.IO) {
            database.getVaccine(id)
        }
}
