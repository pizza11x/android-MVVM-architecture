package com.pizza11x.androidtoolkit.utils

sealed class LoadingStatus()
object Loading: LoadingStatus()
object Completed: LoadingStatus()
object Failed: LoadingStatus()