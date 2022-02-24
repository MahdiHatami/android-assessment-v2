package com.ticketswap.android.assessment.data.repository

import com.ticketswap.android.assessment.data.local.VaccineDatabase
import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.domain.model.QueryResult
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.random.Random

/**
 * Do not review this class, this is a mock implementation meant to simulate a real database.
 */
class BookAppointmentImpl @Inject constructor(
    private val database: VaccineDatabase
) : BookAppointment {
    override fun bookAppointment(): QueryResult.Successful<Single<Boolean>> {
        return QueryResult.Successful(
            Single
                // Simulate success and failure randomly
                .just(Random.nextBoolean())
                // Simulate some network delay
                .delay(Random.nextLong() % 30L, TimeUnit.SECONDS)
        )
    }

    override fun getVaccineById(id: Long): QueryResult<Vaccine> {
        return database.getVaccine(id)
    }
}
