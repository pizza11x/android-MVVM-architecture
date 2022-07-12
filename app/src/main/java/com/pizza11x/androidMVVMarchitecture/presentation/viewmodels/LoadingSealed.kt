package com.pizza11x.androidMVVMarchitecture.presentation.viewmodels

sealed class LoadingStatus
object Loading : LoadingStatus()
object Completed : LoadingStatus()
object Failed : LoadingStatus()
