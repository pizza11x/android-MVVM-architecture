package com.pizza11x.androidMVVMarchitecture.presentation.viewmodels.base

import androidx.lifecycle.MutableLiveData
import com.pizza11x.androidMVVMarchitecture.utils.classes.NavigationCommand
import kotlinx.coroutines.CoroutineDispatcher

abstract class ABaseNavViewModel(coroutineDispatcher: CoroutineDispatcher? = null) :
    ABaseViewModel(coroutineDispatcher), INavViewModel {
    /* VARIABLES */
    override val navLiveData: MutableLiveData<NavigationCommand> = MutableLiveData()
}