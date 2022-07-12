package com.pizza11x.androidMVVMarchitecture.data.di

import com.pizza11x.androidMVVMarchitecture.data.mappers.ErrorMapper
import com.pizza11x.androidMVVMarchitecture.data.mappers.IErrorMapperSource
import com.pizza11x.androidMVVMarchitecture.domain.managers.ErrorManager
import com.pizza11x.androidMVVMarchitecture.domain.usecases.IErrorUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ErrorModule{

    @Binds
    @Singleton
    abstract fun provideErrorFactoryImpl(manager: ErrorManager) : IErrorUseCase

    @Binds
    @Singleton
    abstract fun provideErrorMapper(mapper: ErrorMapper) : IErrorMapperSource

}