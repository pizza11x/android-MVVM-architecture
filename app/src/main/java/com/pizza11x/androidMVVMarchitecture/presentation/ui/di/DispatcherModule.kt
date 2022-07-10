package com.pizza11x.androidMVVMarchitecture.presentation.ui.di

import com.pizza11x.androidMVVMarchitecture.utils.annotations.DefaultDispatcher
import com.pizza11x.androidMVVMarchitecture.utils.annotations.IoDispatcher
import com.pizza11x.androidMVVMarchitecture.utils.annotations.MainDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}
