package com.pizza11x.androidmvvmarchitecture.presentation.viewmodels

sealed class LoadingStatus
object Loading : LoadingStatus()
object Completed : LoadingStatus()
object Failed : LoadingStatus()
