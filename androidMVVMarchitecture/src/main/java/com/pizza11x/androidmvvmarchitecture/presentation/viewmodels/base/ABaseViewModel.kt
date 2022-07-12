package com.pizza11x.androidmvvmarchitecture.presentation.viewmodels.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pizza11x.androidmvvmarchitecture.presentation.viewmodels.Completed
import com.pizza11x.androidmvvmarchitecture.presentation.viewmodels.Failed
import com.pizza11x.androidmvvmarchitecture.presentation.viewmodels.LoadingStatus
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import com.pizza11x.androidmvvmarchitecture.presentation.viewmodels.Loading
import kotlinx.coroutines.launch


abstract class ABaseViewModel(
    private val dispatcher: CoroutineDispatcher? = null
) : ViewModel() {
    /* LIVE DATA */
    var loadingStatus = MutableLiveData<LoadingStatus>()

    /* PROTECTED FUN */
    // COROUTINES
    protected fun defaultCoroutine(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            dispatcher ?: Dispatchers.Default, block = block
        )

    protected fun ioCoroutine(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            dispatcher ?: Dispatchers.IO, block = block
        )

    // LOADING
    protected fun loading() = loadingStatus.postValue(Loading)
    protected fun loadingCompleted() = loadingStatus.postValue(Completed)
    protected fun loadingFailed() = loadingStatus.postValue(Failed)

}