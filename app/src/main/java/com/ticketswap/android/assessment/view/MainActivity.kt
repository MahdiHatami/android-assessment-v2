package com.ticketswap.android.assessment.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ticketswap.android.assessment.R
import com.ticketswap.android.assessment.data.model.Vaccine
import com.ticketswap.android.assessment.view.vaccine.VaccineFragment
import com.ticketswap.android.assessment.view.vaccinesList.VaccinesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}