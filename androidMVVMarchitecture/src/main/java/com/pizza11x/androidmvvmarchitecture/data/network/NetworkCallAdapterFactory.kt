package com.pizza11x.androidmvvmarchitecture.data.network

import com.pizza11x.androidmvvmarchitecture.data.network.NetworkConstants.PARAMETERIZED_TYP_MESSAGE
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class NetworkCallAdapterFactory : CallAdapter.Factory() {

    /* CALL ADAPTER FACTORY FUN */
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java)
            return null
        check(returnType is ParameterizedType) { PARAMETERIZED_TYP_MESSAGE }
        val responseType = getParameterUpperBound(0, returnType)
        if (getRawType(responseType) != NetworkResponse::class.java)
            return null
        check(responseType is ParameterizedType) { PARAMETERIZED_TYP_MESSAGE }

        val errorBodyType = getParameterUpperBound(1, returnType)
        if (getRawType(errorBodyType) != NetworkResponse::class.java)
            return null

        val successBodyType = getParameterUpperBound(1, returnType)
        return NetworkCallAdapter<Any>(successBodyType)


    }
}