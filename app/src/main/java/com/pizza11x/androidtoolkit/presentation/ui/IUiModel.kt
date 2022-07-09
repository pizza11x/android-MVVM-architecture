package com.pizza11x.androidtoolkit.presentation.ui

interface IUiModel {
    /* VARIABLES */
    val id: String

    /* PUBLIC FUN */
    fun areContentsTheSame(obj: IUiModel): Boolean {
        return this == obj

    }
}