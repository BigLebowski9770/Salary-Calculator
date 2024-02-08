package com.loves2spooge.salary_calculator.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun provideRouter(): Router {
        return cicerone.router
    }

    @Provides
    fun provideNavigationHolder(): NavigatorHolder {
        return cicerone.getNavigatorHolder()
    }
}