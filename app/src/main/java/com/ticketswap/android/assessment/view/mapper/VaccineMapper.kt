package com.ticketswap.android.assessment.view.mapper

import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.view.vaccine.ViewVaccineDetailItem
import com.ticketswap.android.assessment.view.vaccinesList.ViewVaccineItem

fun Vaccine.toViewVaccineItem(onClick: () -> Unit) = ViewVaccineItem(
    id = id,
    name = name,
    description = description,
    requiredShots = requiredShots,
    daysBetweenShots = daysBetweenShots,
    onClick = onClick,
)

fun Vaccine.toViewVaccineDetailItem() = ViewVaccineDetailItem(
    id = id,
    name = name,
    description = description,
    requiredShots = requiredShots,
    daysBetweenShots = daysBetweenShots,
)
