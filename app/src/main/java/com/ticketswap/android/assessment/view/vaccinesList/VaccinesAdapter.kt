package com.ticketswap.android.assessment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.view.vaccinesList.VaccinesFragment

/**
 * initializing vaccines list with empty list could prevent some unwanted crash from using !!
 */

/**
 * "Shots required: $shots" instead better to use string resources
 */
class VaccinesAdapter : RecyclerView.Adapter<VaccineViewHolder>() {

    var vaccines: List<Vaccine> = ArrayList()
    var fragment: VaccinesFragment? = null

    override fun getItemCount(): Int {
        return vaccines.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineViewHolder {
        return VaccineViewHolder(parent.context, parent)
    }

    override fun getItemId(position: Int): Long {
        return vaccines[position].id
    }

    override fun onBindViewHolder(holder: VaccineViewHolder, position: Int) {
        vaccines[position].let { vaccine ->
            holder.itemView.findViewById<TextView>(R.id.name).text = vaccine.name
            vaccine.requiredShots?.let { shots ->
                holder.itemView.findViewById<TextView>(R.id.requiredShots).text = "Shots required: $shots"
            }
            vaccine.daysBetweenShots?.let { shots ->
                holder.itemView.findViewById<TextView>(R.id.daysBetweenShots).text = "Days between shots: $shots"
            }

            holder.itemView.setOnClickListener {
                fragment!!.onVaccineSelected(vaccine)
            }
        }
    }
}

/**
 * using binding for vaccine_item as i said in [VaccinesFragment] before about data-binding
 */
class VaccineViewHolder(val context: Context, val parent: ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater.from(context).inflate(R.layout.vaccine_item, parent, false)
)


