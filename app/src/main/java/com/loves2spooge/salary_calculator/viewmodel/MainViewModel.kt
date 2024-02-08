package com.loves2spooge.salary_calculator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import javax.inject.Inject
import javax.inject.Provider

class MainViewModel @Inject constructor(
    private val router: Router,
    private val navigationHolder: NavigatorHolder
) : ViewModel() {

    fun openNewScreen(screen: Screen) {
        router.navigateTo(screen)
    }

    fun getNavHolder(): NavigatorHolder {
        return navigationHolder
    }
}

class MainViewModelFactory @Inject constructor(
    myViewModelProvider: Provider<MainViewModel>
) : ViewModelProvider.Factory {
    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        MainViewModel::class.java to myViewModelProvider
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }
}