package com.ticketswap.android.assessment.view.util

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ticketswap.android.assessment.view.vaccinesList.VaccinesAdapter
import com.ticketswap.android.assessment.view.vaccinesList.ViewVaccineItem

@BindingAdapter("vaccines")
fun RecyclerView.setEpisodes(itemViewModels: List<ViewVaccineItem>?) {
    val adapter = getOrCreateVaccineListAdapter()
    adapter.setVaccines(itemViewModels ?: emptyList())
}

private fun RecyclerView.getOrCreateVaccineListAdapter(): VaccinesAdapter {
    return if (adapter != null && adapter is VaccinesAdapter) {
        adapter as VaccinesAdapter
    } else {
        val newAdapter = VaccinesAdapter()
        adapter = newAdapter
        newAdapter
    }
}

@BindingAdapter("isLoading")
fun ProgressBar.setIsLoading(loadingState: LoadingState?) {
    visibility = if (loadingState == LoadingState.Loading) View.VISIBLE else View.GONE
}
