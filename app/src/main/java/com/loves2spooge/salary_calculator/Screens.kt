package com.loves2spooge.salary_calculator

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.loves2spooge.salary_calculator.fragment.ClockCalculationFragment
import com.loves2spooge.salary_calculator.fragment.RevenueCalculationFragment

object Screens {

    fun RevenueCalcFrag() = FragmentScreen { RevenueCalculationFragment() }
    fun ClockCalcFrag() = FragmentScreen { ClockCalculationFragment() }
}