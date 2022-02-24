package com.ticketswap.android.assessment.view.vaccinesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ticketswap.android.assessment.databinding.FragmentVaccinesBinding
import com.ticketswap.android.assessment.view.BaseFragment
import com.ticketswap.android.assessment.view.util.launchWhileResumed
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

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

    private lateinit var binding: FragmentVaccinesBinding
    private val viewModel by viewModels<VaccinesViewModel> { viewModelFactoryProvider }

    private val adapter = VaccinesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVaccinesBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vaccines.layoutManager = LinearLayoutManager(requireContext())
        binding.vaccines.adapter = adapter

        lifecycle.launchWhileResumed {
            viewModel.selectedVaccine.collectLatest { vaccineId ->
                onVaccineRowClick(vaccineId)
            }
        }

        lifecycle.launchWhileResumed {
            viewModel.onError.collectLatest {
                if (it) showErrorMessage()
            }
        }
    }

    private fun onVaccineRowClick(vaccineId: Long) {
        val action = VaccinesFragmentDirections.actionVaccinesFragmentToVaccineFragment(vaccineId)
        view?.findNavController()?.navigate(action)
    }
}
