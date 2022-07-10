package com.pizza11x.androidtoolkit.presentation.navigation

import androidx.lifecycle.MutableLiveData
import com.pizza11x.androidtoolkit.presentation.navigation.base.ABaseNavigation
import com.pizza11x.androidtoolkit.utils.NavigationCommand

interface INavViewModel {
    /* VARIABLES */
    val navLiveData: MutableLiveData<NavigationCommand>
    val navigator: ABaseNavigation
}