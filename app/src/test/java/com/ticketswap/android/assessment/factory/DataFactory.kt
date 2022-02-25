package com.ticketswap.android.assessment.factory

import java.util.UUID
import java.util.concurrent.ThreadLocalRandom

object DataFactory {

    fun randomString(): String = UUID.randomUUID().toString()

    fun randomInt(min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE): Int =
        ThreadLocalRandom.current().nextInt(min, max)

    fun randomLong(min: Long = Long.MIN_VALUE, max: Long = Long.MAX_VALUE): Long =
        ThreadLocalRandom.current().nextLong(min, max)

    fun randomBoolean(): Boolean = Math.random() < 0.5
}
