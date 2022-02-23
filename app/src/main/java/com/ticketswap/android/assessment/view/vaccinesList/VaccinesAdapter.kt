package com.ticketswap.android.assessment.view.vaccinesList

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ticketswap.android.assessment.R
import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.databinding.VaccineItemBinding

/**
 * initializing vaccines list with empty list could prevent some unwanted crash from using !!
 */

/**
 * "Shots required: $shots" instead better to use string resources
 */
class VaccinesAdapter : RecyclerView.Adapter<VaccineViewHolder>() {

    private var vaccines: List<ViewVaccineItem> = ArrayList()
    var fragment: VaccinesFragment? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setVaccines(vaccines: List<ViewVaccineItem>) {
        this.vaccines = vaccines
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return vaccines.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineViewHolder {
        val binding = VaccineItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VaccineViewHolder(binding)
    }

    override fun getItemId(position: Int): Long {
        return vaccines[position].id
    }

    override fun onBindViewHolder(holder: VaccineViewHolder, position: Int) {
        val vaccine = vaccines[position]
        holder.setVaccine(vaccine)
    }
}

/**
 * using binding for vaccine_item as i said in [VaccinesFragment] before about data-binding
 */
class VaccineViewHolder internal constructor(internal val binding: VaccineItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun setVaccine(vaccine: ViewVaccineItem) {
        binding.vaccine = vaccine
    }
}




