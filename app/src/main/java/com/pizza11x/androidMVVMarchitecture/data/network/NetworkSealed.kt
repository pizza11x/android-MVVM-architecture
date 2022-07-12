package com.pizza11x.androidMVVMarchitecture.data.network

sealed class NetworkResponse<out S, out F> {

    /* PUBLIC FUN */
    inline fun handleResponse(
        succeeded: (S) -> Unit = {},
        failed: (F) -> Unit = {},
        loading: () -> Unit = {}
    ) = when (this) {
        is Failure -> failed(failure)
        is Success -> succeeded(success)
        is Loading -> loading()
    }

    fun ifSuccess(block: (S) -> Unit) {
        if (this is Success)
            block(success)
    }
}

data class Success<out S>(val success: S) : NetworkResponse<S, Nothing>()
data class Failure<out T>(val failure: T) : NetworkResponse<Nothing, T>()
object Loading : NetworkResponse<Nothing, Nothing>()

