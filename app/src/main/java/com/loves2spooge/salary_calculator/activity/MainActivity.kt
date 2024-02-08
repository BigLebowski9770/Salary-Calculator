package com.loves2spooge.salary_calculator.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.loves2spooge.salary_calculator.App
import com.loves2spooge.salary_calculator.R
import com.loves2spooge.salary_calculator.Screens.ClockCalcFrag
import com.loves2spooge.salary_calculator.Screens.RevenueCalcFrag
import com.loves2spooge.salary_calculator.viewmodel.MainViewModel
import com.loves2spooge.salary_calculator.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var buttonPercentageOfRevenue: Button
    private lateinit var buttonPaymentByTheHour: Button

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private val navigator = AppNavigator(this, R.id.container)

    private val mainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as App).appComponent.inject(this)

        setUi()
        setListenerButtons()
    }

    private fun setUi() {
        buttonPercentageOfRevenue = findViewById(R.id.button_percentage_of_revenue)
        buttonPaymentByTheHour = findViewById(R.id.button_payment_by_the_hour)
    }

    private fun setListenerButtons() {
        buttonPercentageOfRevenue.setOnClickListener {
            Log.d("TAG", "buttonPercentageOfRevenue")
            mainViewModel.openNewScreen(RevenueCalcFrag())
        }

        buttonPaymentByTheHour.setOnClickListener {
            Log.d("TAG", "buttonPaymentByTheHour")
            mainViewModel.openNewScreen(ClockCalcFrag())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        mainViewModel.getNavHolder().setNavigator(navigator)
    }

    override fun onPause() {
        mainViewModel.getNavHolder().removeNavigator()
        super.onPause()
    }
}