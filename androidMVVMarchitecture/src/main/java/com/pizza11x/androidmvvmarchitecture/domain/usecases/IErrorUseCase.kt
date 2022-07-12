package com.pizza11x.androidmvvmarchitecture.domain.usecases

import com.pizza11x.androidmvvmarchitecture.data.models.GeneralError

interface IErrorUseCase {
    /* FUN */
    fun getError(code: Int) : GeneralError
}