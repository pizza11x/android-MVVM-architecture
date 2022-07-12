package com.pizza11x.androidMVVMarchitecture.domain.models

interface IUiModel {
    /* VARIABLES */
    val id: String

    /* PUBLIC FUN */
    fun contentsEquals(obj: IUiModel): Boolean {
        return this == obj
    }
}