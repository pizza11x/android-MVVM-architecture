package com.pizza11x.androidMVVMarchitecture.presentation.viewmodels.base

import androidx.lifecycle.MutableLiveData
import com.pizza11x.androidMVVMarchitecture.presentation.navigation.base.ABaseNavigation
import com.pizza11x.androidMVVMarchitecture.utils.classes.NavigationCommand

interface INavViewModel {
    /* VARIABLES */
    val navLiveData: MutableLiveData<NavigationCommand>
    val navigator: ABaseNavigation
}