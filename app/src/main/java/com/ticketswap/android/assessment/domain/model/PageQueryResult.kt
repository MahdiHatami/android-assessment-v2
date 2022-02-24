package com.ticketswap.android.assessment.domain.model

sealed interface PageQueryResult<out T> {
    data class Successful<out T>(val data: T) : PageQueryResult<T>
    object Error : PageQueryResult<Nothing>
}
