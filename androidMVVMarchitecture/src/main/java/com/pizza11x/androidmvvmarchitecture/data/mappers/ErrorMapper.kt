package com.pizza11x.androidmvvmarchitecture.data.mappers

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ErrorMapper @Inject constructor(
    @ApplicationContext val context: Context, override val errorsMap: Map<Int, String>,
) : IErrorMapperSource {

    /* MAPPER SOURCE FUN */
    override fun getErrorMessage(errorMessageID: Int): String = context.getString(errorMessageID)
}