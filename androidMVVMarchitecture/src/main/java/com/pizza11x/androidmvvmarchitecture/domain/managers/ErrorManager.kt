package com.pizza11x.androidmvvmarchitecture.domain.managers

import com.pizza11x.androidmvvmarchitecture.data.mappers.ErrorMapper
import com.pizza11x.androidmvvmarchitecture.domain.usecases.IErrorUseCase
import com.pizza11x.androidmvvmarchitecture.data.models.GeneralError
import javax.inject.Inject

class ErrorManager @Inject constructor(private val mapper: ErrorMapper) : IErrorUseCase {

    /* ERROR USE CASE */
    override fun getError(code: Int): GeneralError {
        return GeneralError(code, mapper.errorsMap.getValue(code))
    }
}