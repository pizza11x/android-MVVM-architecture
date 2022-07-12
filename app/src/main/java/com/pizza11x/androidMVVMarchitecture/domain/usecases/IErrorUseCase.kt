package com.pizza11x.androidMVVMarchitecture.domain.usecases

import com.pizza11x.androidMVVMarchitecture.data.models.Error

interface IErrorUseCase {
    /* FUN */
    fun getError(code: Int) : Error
}