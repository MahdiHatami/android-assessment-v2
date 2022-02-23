package com.ticketswap.android.assessment

import io.reactivex.Single
import java.util.concurrent.TimeUnit
import kotlin.random.Random

/**
 * Do not review this class, this is a mock implementation meant to simulate a real database.
 */
class BookAppointmentImpl : BookAppointment {
    override fun bookAppointment(): Single<Boolean> {
        return Single
                // Simulate success and failure randomly
            .just(Random.nextBoolean())
                // Simulate some network delay
            .delay(Random.nextLong() % 30L, TimeUnit.SECONDS)
    }
}