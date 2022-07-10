package com.pizza11x.androidMVVMarchitecture.utils.annotations

import javax.inject.Qualifier

/* DISPATCHERS */
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainDispatcher