package com.ticketswap.android.assessment.view

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ticketswap.android.assessment.R
import javax.inject.Inject

abstract class BaseFragment : Fragment() {
    @Inject
    lateinit var viewModelFactoryProvider: ViewModelProvider.Factory

    fun showErrorMessage() {
        Toast.makeText(context, R.string.error_message, Toast.LENGTH_LONG).show()
    }

}