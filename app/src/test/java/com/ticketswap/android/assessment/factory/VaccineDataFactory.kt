package com.ticketswap.android.assessment.factory

import com.ticketswap.android.assessment.data.model.Vaccine

object VaccineDataFactory {
    internal fun makeVaccine(id: Long = DataFactory.randomLong()): Vaccine =
        Vaccine(
            id = id,
            name = DataFactory.randomString(),
            description = DataFactory.randomString(),
            requiredShots = DataFactory.randomInt(),
            daysBetweenShots = DataFactory.randomInt()
        )

    internal fun makeVaccinesList(count: Int): List<Vaccine> {
        val vaccinesList: MutableList<Vaccine> = ArrayList()
        repeat(count) {
            val vaccine = makeVaccine()
            vaccinesList.add(vaccine)
        }
        return vaccinesList
    }
}