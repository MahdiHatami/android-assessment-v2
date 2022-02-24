package com.ticketswap.android.assessment.view.vaccine

data class ViewVaccineDetailItem(
    val id: Long,
    val name: String,
    val description: String,
    val requiredShots: Int?,
    val daysBetweenShots: Int?,
)
