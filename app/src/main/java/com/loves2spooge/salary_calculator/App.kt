package com.loves2spooge.salary_calculator

import android.app.Application
import com.loves2spooge.salary_calculator.di.AppComponent
import com.loves2spooge.salary_calculator.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
}