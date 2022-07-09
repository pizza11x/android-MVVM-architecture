package com.pizza11x.androidtoolkit.utils

import android.app.Activity
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/*
    Binding inflate Layout
 */
fun <T : ViewDataBinding> Activity.bindLayout(layout: Int) : T {
    return DataBindingUtil.setContentView(this, layout)

}

fun Fragment.openSoftKeyboard(view: View){
    if(view.requestFocus()){
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
    }
}

fun Fragment.closeSoftKeyboard(){
    view?.let { activity?.closeSoftKeyboard(it) }
}

fun AppCompatActivity.closeSoftKeyboard(){
    currentFocus?.let { closeSoftKeyboard(it) }
}