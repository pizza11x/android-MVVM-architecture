package com.pizza11x.androidmvvmarchitecture.utils.extensions

import android.app.Activity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.pizza11x.androidmvvmarchitecture.presentation.ui.dialogs.LoadingDialogFragment
import com.squareup.picasso.Picasso

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

/* VIEW */
fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.showSnackbar(text: String, time: Int) {
    Snackbar.make(this, text, time).show()
}

/* IMAGE VIEW */
fun ImageView.load(@DrawableRes resId: Int) = Picasso.get().load(resId).into(this)

/* EDIT TEXT */
fun EditText.afterTextChanged(callback: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            callback.invoke(s.toString())
        }

    })
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