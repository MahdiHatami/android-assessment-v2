package com.ticketswap.android.assessment

import com.ticketswap.android.assessment.data.local.VaccineDatabase
import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.data.repository.Repository
import com.ticketswap.android.assessment.data.repository.RepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RepositoryTest {
    @MockK
    lateinit var database: VaccineDatabase

    @MockK
    lateinit var repository: Repository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        repository = RepositoryImpl(database)
    }

    @Test
    fun `getVaccineById hit db once`() = runBlockingTest {
        // GIVEN
        val vaccine = database.getVaccine(1)
        stubQueryVaccineDatabaseGetById(vaccine)

        // WHEN
        repository.getVaccineById(id = 1)

        // THEN
        coVerify(exactly = 1) { database.getVaccine(any()) }
    }

    private fun stubQueryVaccineDatabaseGetById(vaccine: Vaccine) {
        coEvery {
            database.getVaccine(vaccineId = any())
        } returns vaccine
    }
}
