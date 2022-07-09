package com.pizza11x.androidtoolkit.utils

import android.app.Activity
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pizza11x.androidtoolkit.presentation.ui.dialogs.LoadingDialogFragment

/*ACTIVITY */
fun <T : ViewDataBinding> Activity.bindLayout(layout: Int): T {
    return DataBindingUtil.setContentView(this, layout)

}

fun AppCompatActivity.closeSoftKeyboard() {
    currentFocus?.let { closeSoftKeyboard(it) }
}

/* FRAGMENT */
fun Fragment.openSoftKeyboard(view: View) {
    if (view.requestFocus()) {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
    }
}

fun Fragment.closeSoftKeyboard() {
    view?.let { activity?.closeSoftKeyboard(it) }
}

fun Fragment.showLoader() {
    showLoader(requireActivity())
}

fun Fragment.hideLoader() {
    hideLoader(requireActivity())
}

/* BOTTOMSHEET DIALOG FRAGMENT*/

fun BottomSheetDialogFragment.showLoader() {
    showLoader(requireActivity())
}

fun BottomSheetDialogFragment.hideLoader() {
    hideLoader(requireActivity())
}


/* PRIVATE FUN */

private fun showLoader(activity: FragmentActivity) {
    with(activity.supportFragmentManager) {
        if (findFragmentByTag(LoadingDialogFragment.TAG) == null) {
            LoadingDialogFragment().show(
                this,
                LoadingDialogFragment.TAG
            )
        }
    }
}

private fun hideLoader(activity: FragmentActivity) {
    with(activity.supportFragmentManager) {
        findFragmentByTag(LoadingDialogFragment.TAG)?.let {
            if (it is DialogFragment)
                it.dismiss()
        }
    }
}