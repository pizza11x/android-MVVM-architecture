package com.pizza11x.androidmvvmarchitecture.domain.models

interface IUiModel {
    /* VARIABLES */
    val id: String

    /* PUBLIC FUN */
    fun contentsEquals(obj: IUiModel): Boolean {
        return id == obj.id
    }
}