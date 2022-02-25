package com.ticketswap.android.assessment.data.repository

import com.ticketswap.android.assessment.data.local.LocalDataSource
import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.factory.VaccineDataFactory
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
    lateinit var localDataSource: LocalDataSource

    @MockK
    lateinit var repository: Repository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        repository = RepositoryImpl(localDataSource)
    }

    @Test
    fun `getVaccineById hit db once`() = runBlockingTest {
        // GIVEN
        val vaccine = VaccineDataFactory.makeVaccine(1)
        stubQueryVaccineDatabaseGetById(vaccine)

        // WHEN
        repository.getVaccineById(id = 1)

        // THEN
        coVerify(exactly = 1) { localDataSource.getVaccine(any()) }
    }

    private fun stubQueryVaccineDatabaseGetById(vaccine: Vaccine) {
        coEvery {
            localDataSource.getVaccine(vaccineId = any())
        } returns vaccine
    }
}
