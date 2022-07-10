package com.pizza11x.androidtoolkit.presentation.navigation.base

import com.pizza11x.androidtoolkit.utils.NavigationCommand

abstract class ABaseNavigation {

    /* PUBLIC FUN */
    fun goBack() = NavigationCommand.GoBack

    fun goToStartDestination() = NavigationCommand.GoToStartDestination
}