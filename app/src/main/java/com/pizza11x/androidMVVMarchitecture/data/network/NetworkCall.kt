package com.pizza11x.androidMVVMarchitecture.data.network

import com.google.gson.Gson
import com.pizza11x.androidMVVMarchitecture.data.network.NetworkConstants.EMPTY_RESPONSE_BODY_MESSAGE
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.lang.Exception
import java.lang.UnsupportedOperationException
import java.lang.reflect.Type

class NetworkCall<R>(
    private val delegate: Call<R>,
    private val successBodyType: Type
) : Call<NetworkResponse<R, ApiError>> {
    /* VARIABLES */
    private val gson by lazy { Gson() }

    /* CALL FUN */
    override fun enqueue(callback: Callback<NetworkResponse<R, ApiError>>) = delegate.enqueue(
        object : Callback<R> {

            /* CALLBACK FUN */
            override fun onResponse(call: Call<R>, response: Response<R>) {
                callback.onResponse(
                    this@NetworkCall,
                    Response.success(response.createResponse())
                )
            }

            override fun onFailure(call: Call<R>, t: Throwable) {
                val networkResponse = when (t) {
                    is IOException -> NetworkError(t)
                    else -> UnknownError(t)
                }
                callback.onResponse(this@NetworkCall, Response.success(Failure(networkResponse)))
            }

            /* PRIVATE CALLBACK FUN */
            private fun Response<R>.createResponse(): NetworkResponse<R, ApiError> {
                if (!isSuccessful) {
                    return try {
                        val errorModel = gson.fromJson<Any>(errorBody()?.string(), successBodyType)
                        Failure(HttpError(code(), errorModel))
                    } catch (ex: Exception) {
                        Failure(HttpError(code(), errorBody()?.string() ?: ""))
                    }
                }

                body()?.let { body -> return Success(body) }

                return if (successBodyType == Unit::class.java) {
                    @Suppress("UNCHECKED_CAST")
                    Success(Unit) as NetworkResponse<R, ApiError>
                } else {
                    Failure(UnknownError(Exception(EMPTY_RESPONSE_BODY_MESSAGE)))
                }
            }

        }
    )

    override fun execute(): Response<NetworkResponse<R, ApiError>> =
        throw UnsupportedOperationException()

    override fun clone(): Call<NetworkResponse<R, ApiError>> =
        NetworkCall(delegate.clone(), successBodyType)

    override fun isExecuted(): Boolean = delegate.isExecuted
    override fun cancel() = delegate.cancel()
    override fun isCanceled(): Boolean = delegate.isCanceled
    override fun request(): Request = delegate.request()
    override fun timeout(): Timeout = delegate.timeout()
}