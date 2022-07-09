package com.pizza11x.androidtoolkit.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/* DATA BINDING */
fun <T : ViewDataBinding> bindLayout(
    inflater: LayoutInflater,
    layout: Int,
    viewGroup: ViewGroup?
): T {
    return DataBindingUtil.inflate(inflater, layout, viewGroup, false)
}

/* CONTEXT */
fun Context.closeSoftKeyboard(view: View) {
    val inputMethodManager =
        getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}