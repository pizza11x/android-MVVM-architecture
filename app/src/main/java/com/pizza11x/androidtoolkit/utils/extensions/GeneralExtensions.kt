package com.pizza11x.androidtoolkit.utils.extensions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/* DATA BINDING */
fun <T : ViewDataBinding> bindLayout(
    inflater: LayoutInflater,
    layout: Int,
    viewGroup: ViewGroup?
): T {
    return DataBindingUtil.inflate(inflater, layout, viewGroup, false)
}

/* CONTEXT */
fun Context.closeKeyboard(view: View) {
    val inputMethodManager =
        getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

/* LIVE DATA */
fun <T> LiveData<T>.observeOnce(lifecycleOwner: LifecycleOwner, observer: Observer<T>) {
    observe(lifecycleOwner, object : Observer<T> {
        override fun onChanged(t: T?) {
            observer.onChanged(t)
            removeObserver(this)
        }
    })
}

/* LIVE DATA */
fun <T> LiveData<T>.observeNonNull(lifecycleOwner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(lifecycleOwner, Observer {
        it?.let(observer)
    })
}