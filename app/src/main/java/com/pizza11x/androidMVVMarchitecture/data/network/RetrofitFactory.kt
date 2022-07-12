package com.pizza11x.androidMVVMarchitecture.data.network

import com.pizza11x.androidMVVMarchitecture.data.network.NetworkConstants.TIMEOUT
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

open class RetrofitFactory (
    interceptors: MutableList<Interceptor> = mutableListOf(),
    networkInterceptor: MutableList<Interceptor> = mutableListOf(),
    converterFactories: MutableList<Converter.Factory> = mutableListOf(),
    callAdaptersFactories: MutableList<CallAdapter.Factory> = mutableListOf(),
    timeout: Long = TIMEOUT
) {
    /* VARIABLES */
    private val builder: Retrofit.Builder = Retrofit.Builder()
    private lateinit var retrofit: Retrofit

    init {
        val clientBuilder = OkHttpClient.Builder()
        clientBuilder.callTimeout(timeout, TimeUnit.SECONDS)
        clientBuilder.connectTimeout(timeout, TimeUnit.SECONDS)
        clientBuilder.writeTimeout(timeout, TimeUnit.SECONDS)
        clientBuilder.readTimeout(timeout, TimeUnit.SECONDS)

        interceptors.forEach { clientBuilder.addInterceptor(it) }
        networkInterceptor.forEach { clientBuilder.addNetworkInterceptor(it) }
        converterFactories.forEach { builder.addConverterFactory(it) }
        callAdaptersFactories.forEach { builder.addCallAdapterFactory(it) }

        builder.client(clientBuilder.build())
    }

    /* PUBLIC FUN */
    fun <S> createService(url: String, serviceClass: Class<S>) : S{
        retrofit = builder.baseUrl(url).build()
        return retrofit.create(serviceClass)
    }
}