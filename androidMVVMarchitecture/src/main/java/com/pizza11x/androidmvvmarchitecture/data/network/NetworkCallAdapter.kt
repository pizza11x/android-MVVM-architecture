package com.pizza11x.androidmvvmarchitecture.data.network

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class NetworkCallAdapter<R>(
    private val successBodyType: Type
) : CallAdapter<R, Call<NetworkResponse<R, ApiError>>> {

    /* CALL ADAPTER FUN */
    override fun responseType(): Type = successBodyType

    override fun adapt(call: Call<R>): Call<NetworkResponse<R, ApiError>> =
        NetworkCall(call, successBodyType)
}