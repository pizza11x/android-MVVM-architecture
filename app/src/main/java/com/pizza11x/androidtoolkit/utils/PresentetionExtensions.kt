package com.pizza11x.androidtoolkit.utils

import android.app.Activity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/*
    Binding inflate Layout
 */
fun <T : ViewDataBinding> Activity.bindLayout(layout: Int) : T {
    return DataBindingUtil.setContentView(this, layout)

}