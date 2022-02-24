package com.ticketswap.android.assessment.view.vaccinesList

data class ViewVaccineItem(
    val id: Long,
    val name: String,
    val description: String,
    val requiredShots: Int?,
    val daysBetweenShots: Int?,
    val onClick: () -> Unit,
) {
    fun onClick() = onClick.invoke()
}
