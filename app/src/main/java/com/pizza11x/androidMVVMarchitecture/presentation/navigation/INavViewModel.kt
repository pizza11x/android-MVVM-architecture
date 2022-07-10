package com.pizza11x.androidMVVMarchitecture.presentation.navigation

import androidx.lifecycle.MutableLiveData
import com.pizza11x.androidMVVMarchitecture.presentation.navigation.base.ABaseNavigation
import com.pizza11x.androidMVVMarchitecture.utils.NavigationCommand

interface INavViewModel {
    /* VARIABLES */
    val navLiveData: MutableLiveData<NavigationCommand>
    val navigator: ABaseNavigation
}