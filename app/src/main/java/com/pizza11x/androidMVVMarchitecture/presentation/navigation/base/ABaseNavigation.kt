package com.pizza11x.androidMVVMarchitecture.presentation.navigation.base

import com.pizza11x.androidMVVMarchitecture.utils.classes.NavigationCommand

abstract class ABaseNavigation {

    /* PUBLIC FUN */
    fun goBack() = NavigationCommand.GoBack

    fun goToStartDestination() = NavigationCommand.GoToStartDestination
}