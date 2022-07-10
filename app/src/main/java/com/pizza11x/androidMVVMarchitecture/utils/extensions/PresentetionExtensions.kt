package com.pizza11x.androidMVVMarchitecture.utils.extensions

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
import com.pizza11x.androidMVVMarchitecture.presentation.ui.dialogs.LoadingDialogFragment

/*ACTIVITY */
fun <T : ViewDataBinding> Activity.bindLayout(layout: Int): T {
    return DataBindingUtil.setContentView(this, layout)

}

fun AppCompatActivity.closeKeyboard() {
    currentFocus?.let { closeKeyboard(it) }
}

/* FRAGMENT */
fun Fragment.openKeyboard(view: View) {
    if (view.requestFocus()) {
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
    }
}

fun Fragment.closeKeyboard() {
    view?.let { activity?.closeKeyboard(it) }
}

fun Fragment.loading() {
    loading(requireActivity())
}

fun Fragment.loadingDismiss() {
    loadingDismiss(requireActivity())
}

/* BOTTOM SHEET DIALOG FRAGMENT*/

fun BottomSheetDialogFragment.loading() {
    loading(requireActivity())
}

fun BottomSheetDialogFragment.loadingDismiss() {
    loadingDismiss(requireActivity())
}


/* PRIVATE FUN */

private fun loading(activity: FragmentActivity) {
    with(activity.supportFragmentManager) {
        if (findFragmentByTag(LoadingDialogFragment.TAG) == null) {
            LoadingDialogFragment().show(
                this,
                LoadingDialogFragment.TAG
            )
        }
    }
}

private fun loadingDismiss(activity: FragmentActivity) {
    with(activity.supportFragmentManager) {
        findFragmentByTag(LoadingDialogFragment.TAG)?.let {
            if (it is DialogFragment)
                it.dismiss()
        }
    }
}