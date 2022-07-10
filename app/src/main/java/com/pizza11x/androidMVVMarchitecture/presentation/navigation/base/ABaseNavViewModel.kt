package com.pizza11x.androidMVVMarchitecture.presentation.navigation.base

import androidx.lifecycle.MutableLiveData
import com.pizza11x.androidMVVMarchitecture.presentation.navigation.INavViewModel
import com.pizza11x.androidMVVMarchitecture.presentation.viewmodel.base.ABaseViewModel
import com.pizza11x.androidMVVMarchitecture.utils.NavigationCommand
import kotlinx.coroutines.CoroutineDispatcher

abstract class ABaseNavViewModel(coroutineDispatcher: CoroutineDispatcher? = null) :
    ABaseViewModel(coroutineDispatcher), INavViewModel {
    /* VARIABLES */
    override val navLiveData: MutableLiveData<NavigationCommand> = MutableLiveData()
}