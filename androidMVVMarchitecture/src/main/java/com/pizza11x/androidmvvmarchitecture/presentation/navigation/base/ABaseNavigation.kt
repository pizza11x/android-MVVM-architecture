package com.pizza11x.androidmvvmarchitecture.presentation.navigation.base

import com.pizza11x.androidmvvmarchitecture.presentation.navigation.NavigationCommand

abstract class ABaseNavigation {

    /* PUBLIC FUN */
    fun goBack() = NavigationCommand.GoBack

    fun goToStartDestination() = NavigationCommand.GoToStartDestination
}