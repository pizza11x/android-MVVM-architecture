package com.pizza11x.androidMVVMarchitecture.data.models

import java.lang.Exception

class Error(val code: Int, val message: String) {
    constructor(exception: Exception) : this(DEFAULT_ERROR, exception.message ?: "")

    companion object {
        const val DEFAULT_ERROR = -1
        const val INTERNET_ERROR = -2
        const val NETWORK_ERROR = -3
        const val SEARCH_ERROR = -4
    }
}