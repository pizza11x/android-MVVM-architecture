package com.pizza11x.androidmvvmarchitecture.data.network

import okhttp3.Interceptor
import retrofit2.CallAdapter
import retrofit2.Converter

data class RetrofitBuilder(
    private var interceptors: MutableList<Interceptor> = mutableListOf(),
    private var networkInterceptor: MutableList<Interceptor> = mutableListOf(),
    private var converterFactories: MutableList<Converter.Factory> = mutableListOf(),
    private var callAdapterFactories: MutableList<CallAdapter.Factory> = mutableListOf(),
) {
    /* Public FUN */
    fun build() = ORetrofitFactory(
        interceptors, networkInterceptor, converterFactories, callAdapterFactories
    )

    fun addInterceptors(vararg interceptors: Interceptor) =
        apply { this.interceptors.addAll(interceptors) }

    fun addNetworkInterceptors(vararg networkInterceptor: Interceptor) =
        apply { this.networkInterceptor.addAll(networkInterceptor) }

    fun addConverterFactories(vararg converters: Converter.Factory) =
        apply { this.converterFactories.addAll(converters) }

    fun addCallAdaptersFactories(vararg adapters: CallAdapter.Factory) =
        apply { this.callAdapterFactories.addAll(adapters) }

}