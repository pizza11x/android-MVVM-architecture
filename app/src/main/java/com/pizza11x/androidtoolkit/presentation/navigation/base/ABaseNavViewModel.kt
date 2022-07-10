package com.pizza11x.androidtoolkit.presentation.navigation.base

import androidx.lifecycle.MutableLiveData
import com.pizza11x.androidtoolkit.presentation.navigation.INavViewModel
import com.pizza11x.androidtoolkit.presentation.viewmodel.base.ABaseViewModel
import com.pizza11x.androidtoolkit.utils.NavigationCommand
import kotlinx.coroutines.CoroutineDispatcher

abstract class ABaseNavViewModel(coroutineDispatcher: CoroutineDispatcher? = null) :
    ABaseViewModel(coroutineDispatcher), INavViewModel {
    /* VARIABLES */
    override val navLiveData: MutableLiveData<NavigationCommand> = MutableLiveData()
}