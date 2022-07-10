package com.pizza11x.androidMVVMarchitecture.data.repositories

import com.pizza11x.androidMVVMarchitecture.data.network.Loading
import com.pizza11x.androidMVVMarchitecture.data.network.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class ABaseRepository {

    /* PUBLIC FUN */
    suspend fun <ResponseModel, ErrorModel> makeCall(
        callBlock: suspend () -> NetworkResponse<ResponseModel, ErrorModel>
    ): Flow<NetworkResponse<ResponseModel, ErrorModel>> = flow {
        emit(Loading)

        emit(callBlock())
    }
}