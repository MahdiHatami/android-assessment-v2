package com.ticketswap.android.assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // commitNowAllowingStateLoss sounds like a code smell in a way that we know know the state
        // of the app for handling the fragments
        // i would rather use the commit() and some lifecycle control state
        supportFragmentManager.beginTransaction().add(R.id.container, VaccinesFragment()).commitNowAllowingStateLoss()
    }

    fun goToVaccine(vaccine: Vaccine) {

        val fragment = VaccineFragment()
        val args = Bundle()
        args.putLong("id", vaccine.id)
        args.putString("name", vaccine.name)
        args.putString("description", vaccine.description)
        args.putInt("requiredShots", vaccine.requiredShots ?: 0)
        args.putInt("daysBetweenShots", vaccine.daysBetweenShots ?: 0)
        args.putInt("peopleVaccinated", 100)
        args.putString("safetyNotes", "")
        fragment.arguments = args

        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commitNowAllowingStateLoss()

    }
}