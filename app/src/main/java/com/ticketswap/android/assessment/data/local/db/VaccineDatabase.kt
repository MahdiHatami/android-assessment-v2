package com.ticketswap.android.assessment.data.local.db

import com.ticketswap.android.assessment.data.model.Vaccine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

private val list = listOf(
    Vaccine(
        id = 1L,
        name = "Moderna",
        requiredShots = 2,
        daysBetweenShots = 21,
        description = "CDC Monitoring Reports of Myocarditis and Pericarditis\n" +
                "CDC has received increased reports of myocarditis and pericarditis in adolescents and young adults after COVID-19 vaccination. The known and potential benefits of COVID-19 vaccination outweigh the known and potential risks, including the possible risk of myocarditis or pericarditis. We continue to recommend COVID-19 vaccination for anyone 12 years of age and older."
    ),
    Vaccine(
        id = 2L,
        name = "Pfizer",
        requiredShots = 2,
        daysBetweenShots = 34,
        description = "CDC Monitoring Reports of Myocarditis and Pericarditis\n" +
                "CDC has received increased reports of myocarditis and pericarditis in adolescents and young adults after COVID-19 vaccination. The known and potential benefits of COVID-19 vaccination outweigh the known and potential risks, including the possible risk of myocarditis or pericarditis. We continue to recommend COVID-19 vaccination for anyone 12 years of age and older."
    ),
    Vaccine(
        id = 3L,
        name = "Astra Zeneca",
        requiredShots = 2,
        daysBetweenShots = 48,
        description = "CDC Monitoring Reports of Myocarditis and Pericarditis\n" +
                "CDC has received increased reports of myocarditis and pericarditis in adolescents and young adults after COVID-19 vaccination. The known and potential benefits of COVID-19 vaccination outweigh the known and potential risks, including the possible risk of myocarditis or pericarditis. We continue to recommend COVID-19 vaccination for anyone 12 years of age and older."
    ),
    Vaccine(
        id = 4L,
        name = "Shady BigPharma affiliate #1",
        requiredShots = 6,
        daysBetweenShots = 12,
        description = "CDC Monitoring Reports of Myocarditis and Pericarditis\n" +
                "CDC has received increased reports of myocarditis and pericarditis in adolescents and young adults after COVID-19 vaccination. The known and potential benefits of COVID-19 vaccination outweigh the known and potential risks, including the possible risk of myocarditis or pericarditis. We continue to recommend COVID-19 vaccination for anyone 12 years of age and older."
    ),
    Vaccine(
        id = 5L,
        name = "Shady BigPharma affiliate #2",
        requiredShots = 2,
        daysBetweenShots = 16,
        description = "CDC Monitoring Reports of Myocarditis and Pericarditis\n" +
                "CDC has received increased reports of myocarditis and pericarditis in adolescents and young adults after COVID-19 vaccination. The known and potential benefits of COVID-19 vaccination outweigh the known and potential risks, including the possible risk of myocarditis or pericarditis. We continue to recommend COVID-19 vaccination for anyone 12 years of age and older."
    ),
    Vaccine(
        id = 6L,
        name = "Shady BigPharma affiliate #3",
        requiredShots = null,
        daysBetweenShots = 45,
        description = "CDC Monitoring Reports of Myocarditis and Pericarditis\n" +
                "CDC has received increased reports of myocarditis and pericarditis in adolescents and young adults after COVID-19 vaccination. The known and potential benefits of COVID-19 vaccination outweigh the known and potential risks, including the possible risk of myocarditis or pericarditis. We continue to recommend COVID-19 vaccination for anyone 12 years of age and older."
    ),
    Vaccine(
        id = 7L,
        name = "Shady BigPharma affiliate #4",
        requiredShots = 7,
        daysBetweenShots = null,
        description = "CDC Monitoring Reports of Myocarditis and Pericarditis\n" +
                "CDC has received increased reports of myocarditis and pericarditis in adolescents and young adults after COVID-19 vaccination. The known and potential benefits of COVID-19 vaccination outweigh the known and potential risks, including the possible risk of myocarditis or pericarditis. We continue to recommend COVID-19 vaccination for anyone 12 years of age and older."
    ),
    Vaccine(
        id = 8L,
        name = "Shady BigPharma affiliate #5",
        requiredShots = 2,
        daysBetweenShots = 12,
        description = "CDC Monitoring Reports of Myocarditis and Pericarditis\n" +
                "CDC has received increased reports of myocarditis and pericarditis in adolescents and young adults after COVID-19 vaccination. The known and potential benefits of COVID-19 vaccination outweigh the known and potential risks, including the possible risk of myocarditis or pericarditis. We continue to recommend COVID-19 vaccination for anyone 12 years of age and older."
    )
)

class VaccineDatabase {

    suspend fun getVaccines(): List<Vaccine> = withContext(Dispatchers.IO) {
        delay(1000L)
        list
    }

    suspend fun getVaccine(vaccineId: Long): Vaccine = withContext(Dispatchers.IO) {
        val vaccine = list.first {
            it.id == vaccineId
        }
        vaccine
    }

    suspend fun bookAppointment() = withContext(Dispatchers.IO) {
        Random.nextBoolean().also { delay(Random.nextLong() % 30L) }
    }
}
