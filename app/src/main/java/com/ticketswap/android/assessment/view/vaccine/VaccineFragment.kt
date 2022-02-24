package com.ticketswap.android.assessment.view.vaccine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ticketswap.android.assessment.R
import com.ticketswap.android.assessment.databinding.FragmentVaccineBinding
import com.ticketswap.android.assessment.view.BaseFragment
import com.ticketswap.android.assessment.view.util.launchWhileResumed
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class VaccineFragment : BaseFragment() {

    private lateinit var binding: FragmentVaccineBinding
    private val viewModel by viewModels<VaccineViewModel> { viewModelFactoryProvider }
    private val args: VaccineFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVaccineBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadVaccineDetail(args.vaccineId)

        lifecycle.launchWhileResumed {
            viewModel.confirmAppointment.collectLatest {
                if (it) {
                    Toast.makeText(
                        context, getString(R.string.got_appointment), Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        lifecycle.launchWhileResumed {
            viewModel.onError.collectLatest {
                if (it) showErrorMessage()
            }
        }
    }
}
