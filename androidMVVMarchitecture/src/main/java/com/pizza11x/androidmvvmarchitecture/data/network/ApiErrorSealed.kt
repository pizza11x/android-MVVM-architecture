package com.pizza11x.androidmvvmarchitecture.data.network

sealed class ApiError

data class HttpError(val code: Int, val body: Any?) : ApiError()
data class NetworkError(val throwable: Throwable) : ApiError()
data class UnknownError(val throwable: Throwable) : ApiError()