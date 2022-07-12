package com.pizza11x.androidmvvmarchitecture.data.mappers

import android.content.Context
import com.pizza11x.androidmvvmarchitecture.data.mappers.IErrorMapperSource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ErrorMapper @Inject constructor(
    @ApplicationContext val context: Context, override val errorsMap: Map<Int, String>,
) : IErrorMapperSource {

    /* MAPPER SOURCE FUN */
    override fun getErrorMessage(errorCode: Int): String = context.getString(errorCode)
}