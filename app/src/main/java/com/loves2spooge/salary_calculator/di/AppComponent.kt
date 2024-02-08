package com.loves2spooge.salary_calculator.di

import com.loves2spooge.salary_calculator.activity.MainActivity
import dagger.Component

@Component(
    modules = [
        NavigationModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)

}