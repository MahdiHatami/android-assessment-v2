package com.ticketswap.android.assessment.data.repository

import io.reactivex.Single

interface BookAppointment {
    fun bookAppointment(): Single<Boolean>
}