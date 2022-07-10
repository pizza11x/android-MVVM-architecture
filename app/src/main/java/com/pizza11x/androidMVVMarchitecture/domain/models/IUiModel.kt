package com.pizza11x.androidMVVMarchitecture.domain.models

interface IUiModel {
    /* VARIABLES */
    val id: String

    /* PUBLIC FUN */
    fun areContentsTheSame(obj: IUiModel): Boolean {
        return this == obj

    }
}