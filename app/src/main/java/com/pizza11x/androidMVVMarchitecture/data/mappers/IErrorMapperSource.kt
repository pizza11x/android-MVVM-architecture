package com.pizza11x.androidMVVMarchitecture.data.mappers

interface IErrorMapperSource {
    /* VARIABLES */
    val errorsMap : Map<Int, String>

    /* FUN */
    fun getErrorMessage(errorCode: Int) : String
}