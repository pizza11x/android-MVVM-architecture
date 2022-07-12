package com.pizza11x.androidmvvmarchitecture.data.di

import com.pizza11x.androidmvvmarchitecture.data.mappers.ErrorMapper
import com.pizza11x.androidmvvmarchitecture.data.mappers.IErrorMapperSource
import com.pizza11x.androidmvvmarchitecture.domain.managers.ErrorManager
import com.pizza11x.androidmvvmarchitecture.domain.usecases.IErrorUseCase
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