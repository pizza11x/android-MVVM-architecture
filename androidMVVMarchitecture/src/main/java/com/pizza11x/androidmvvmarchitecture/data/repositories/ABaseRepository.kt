package com.pizza11x.androidmvvmarchitecture.data.repositories

import com.pizza11x.androidmvvmarchitecture.data.network.Loading
import com.pizza11x.androidmvvmarchitecture.data.network.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class ABaseRepository {

    /* PUBLIC FUN */
    suspend fun <ResponseModel, ErrorModel> executeCall(
        callBlock: suspend () -> NetworkResponse<ResponseModel, ErrorModel>
    ): Flow<NetworkResponse<ResponseModel, ErrorModel>> = flow {
        emit(Loading)

        emit(callBlock())
    }
}