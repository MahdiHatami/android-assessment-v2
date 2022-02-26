package com.ticketswap.android.assessment.data.repository

import com.ticketswap.android.assessment.data.local.LocalDataSource
import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.factory.VaccineDataFactory
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RepositoryTest {
    @MockK
    lateinit var localDataSource: LocalDataSource

    lateinit var repository: Repository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        repository = RepositoryImpl(localDataSource)
    }

    @Test
    fun `getVaccineById hit db once`() = runBlocking{
        // GIVEN
        stubQueryVaccineDatabaseGetById(VaccineDataFactory.makeVaccine(1))

        // WHEN
        repository.getVaccineById(id = 1)

        // THEN
        coVerify(exactly = 1) { localDataSource.getVaccine(any()) }
    }

    @Test
    fun `getVaccines should return list of vaccines`() = runBlocking {
        // GIVEN
        stubQueryVaccinesList(VaccineDataFactory.makeVaccinesList(5))

        // WHEN
        repository.getVaccines()

        // THEN
        coVerify { localDataSource.getVaccines() }
    }

    @Test
    fun `when booking appointment should return random boolean`() = runBlocking {
        // GIVEN
        stubMakeAppointment(VaccineDataFactory.makeAppointment())

        // WHEN
        repository.bookAppointment()

        // THEN
        coVerify { localDataSource.bookAppointment() }
    }

    private fun stubMakeAppointment(appointment: Boolean) {
        coEvery {
            localDataSource.bookAppointment()
        } returns appointment
    }

    private fun stubQueryVaccinesList(vaccines: List<Vaccine>) {
        coEvery {
            localDataSource.getVaccines()
        } returns vaccines
    }

    private fun stubQueryVaccineDatabaseGetById(vaccine: Vaccine) {
        coEvery {
            localDataSource.getVaccine(vaccineId = any())
        } returns vaccine
    }
}
