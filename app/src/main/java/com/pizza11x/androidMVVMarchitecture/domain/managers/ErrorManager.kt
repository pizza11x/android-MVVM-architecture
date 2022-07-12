package com.pizza11x.androidMVVMarchitecture.domain.managers

import com.pizza11x.androidMVVMarchitecture.data.mappers.ErrorMapper
import com.pizza11x.androidMVVMarchitecture.domain.usecases.IErrorUseCase
import com.pizza11x.androidMVVMarchitecture.data.models.Error
import javax.inject.Inject

class ErrorManager @Inject constructor(private val mapper: ErrorMapper) : IErrorUseCase{

    /* ERROR USE CASE */
    override fun getError(code: Int): Error {
        return Error(code, mapper.errorsMap.getValue(code))
    }
}