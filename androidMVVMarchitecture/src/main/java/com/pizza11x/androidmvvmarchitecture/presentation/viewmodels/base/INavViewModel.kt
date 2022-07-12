package com.pizza11x.androidmvvmarchitecture.presentation.viewmodels.base

import androidx.lifecycle.MutableLiveData
import com.pizza11x.androidmvvmarchitecture.presentation.navigation.base.ABaseNavigation
import com.pizza11x.androidmvvmarchitecture.presentation.navigation.NavigationCommand

interface INavViewModel {
    /* VARIABLES */
    val navLiveData: MutableLiveData<NavigationCommand>
    val navigator: ABaseNavigation
}