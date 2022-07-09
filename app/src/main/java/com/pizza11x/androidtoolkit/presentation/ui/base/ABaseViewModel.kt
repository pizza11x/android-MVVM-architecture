package com.pizza11x.androidtoolkit.presentation.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pizza11x.androidtoolkit.utils.*
import com.pizza11x.androidtoolkit.utils.annotations.DefaultDispatcher
import com.pizza11x.androidtoolkit.utils.annotations.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject


abstract class ABaseViewModel @Inject constructor(
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    /* LIVE DATA */
    var loadingStatus = MutableLiveData<LoadingStatus>()

    /* PROTECTED FUN */
    // COROUTINES
    protected fun defaultCoroutine(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            dispatcher, block = block
        )

    protected fun ioCoroutine(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            ioDispatcher, block = block
        )

    // LOADING
    protected fun loading() = loadingStatus.postValue(Loading)
    protected fun loadingCompleted() = loadingStatus.postValue(Completed)
    protected fun loadingFailed() = loadingStatus.postValue(Failed)

}