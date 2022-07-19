package com.pizza11x.androidmvvmarchitecture.presentation.navigation

import androidx.lifecycle.MutableLiveData
import com.pizza11x.androidmvvmarchitecture.presentation.viewmodels.base.ABaseViewModel
import kotlinx.coroutines.CoroutineDispatcher

abstract class ANavViewModel(coroutineDispatcher: CoroutineDispatcher? = null) :
    ABaseViewModel(coroutineDispatcher), INavViewModel {
    /* VARIABLES */
    override val navLiveData: MutableLiveData<NavigationCommand> = MutableLiveData()
}