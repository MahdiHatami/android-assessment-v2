package com.ticketswap.android.assessment.view.util

sealed interface LoadingState {
    object None : LoadingState
    object Loading : LoadingState
    object LoadingMore : LoadingState
}
