package com.ticketswap.android.assessment

import io.reactivex.Single

interface BookAppointment {
    fun bookAppointment(): Single<Boolean>
}