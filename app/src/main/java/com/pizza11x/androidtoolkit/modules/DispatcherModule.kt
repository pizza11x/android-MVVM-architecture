package com.pizza11x.androidtoolkit.modules

import com.pizza11x.androidtoolkit.utils.annotations.DefaultDispatcher
import com.pizza11x.androidtoolkit.utils.annotations.IoDispatcher
import com.pizza11x.androidtoolkit.utils.annotations.MainDispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
object DispatcherModule{
    @DefaultDispatcher
    @Provides
    fun providesDefualtDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}
