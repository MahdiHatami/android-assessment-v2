package com.ticketswap.android.assessment.data.model

data class Vaccine(
    val id: Long,
    val name: String,
    val description: String,
    val requiredShots: Int?,
    val daysBetweenShots: Int?)