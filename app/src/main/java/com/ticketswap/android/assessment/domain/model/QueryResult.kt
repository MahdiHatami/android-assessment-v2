package com.ticketswap.android.assessment.domain.model

sealed interface QueryResult<out T> {
    data class Successful<out T>(val data: T) : QueryResult<T>
    object Error : QueryResult<Nothing>
}