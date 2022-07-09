package com.pizza11x.androidtoolkit.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> bindLayout(
    inflater: LayoutInflater,
    layout: Int,
    viewGroup: ViewGroup
): T {
    return DataBindingUtil.inflate(inflater, layout, viewGroup, false)
}