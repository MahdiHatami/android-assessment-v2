package com.ticketswap.android.assessment.view.vaccinesList

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ticketswap.android.assessment.view.MainActivity
import com.ticketswap.android.assessment.R
import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.VaccinesAdapter
import com.ticketswap.android.assessment.view.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * using data-binding would be better choice fon handling the views for below reasons:
 * 1- Fewer Errors: binding is checked at compile time.
 * 2- Faster app: Since the binding isn’t done in onCreate
 * 3- Safer Connection between views and code: Because it doesn’t bind at runtime,
 * 4- Testing the UI with data-binding is easier
 * 5- Safer Connection between views and actions: It is safer than relying on onClick(),
 *    which can crash if you didn’t implement the requested method.
 */

/**
 * Using Dependency Injection benefits to use:
 * 1- It brings loose-coupling
 * 2- It makes our code reusable and clean
 * 3- It make replacing our dependencies with face implementation easy for testing purpose
 */

/**
 * (activity!! as MainActivity).goToVaccine(vaccine)
 */

@AndroidEntryPoint
class VaccinesFragment : BaseFragment() {

    private val viewModel by viewModels<VaccinesViewModel> { viewModelFactoryProvider }
//    @Inject lateinit var adapter: VaccinesAdapter

    val adapter = VaccinesAdapter()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_vaccines, container, false)

        view.findViewById<RecyclerView>(R.id.vaccines).layoutManager = LinearLayoutManager(requireContext())
        view.findViewById<RecyclerView>(R.id.vaccines).adapter = adapter
        adapter.fragment = this

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.vaccinesList.observe(viewLifecycleOwner, {
            adapter.vaccines = it
            adapter.notifyDataSetChanged()
        })
    }

    @SuppressLint("UseRequireInsteadOfGet")
    fun onVaccineSelected(vaccine: Vaccine) {
        /**
         * what if our activity returns null then our app is going to crash
         * one of the best ways to communicate fragment with activity or another fragment by using
         * listeners or sharing viewModels between two classes
         */
        (activity!! as MainActivity).goToVaccine(vaccine)
    }
}