package com.pizza11x.androidtoolkit.presentation.ui.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.pizza11x.androidtoolkit.R

class LoadingDialogFragment : DialogFragment() {

    /* DIALOG FRAGMENT FUN */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            isCancelable = false
        }
        return inflater.inflate(R.layout.fragment_loading, container, false)
    }

    companion object{
        const val TAG = "LOADER_DIALOG"
    }
}