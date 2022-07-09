package com.pizza11x.androidtoolkit.presentation.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.pizza11x.androidtoolkit.R

class LoadingDialogFragment : DialogFragment() {

    companion object{
        const val TAG = "LOADER_DIALOG"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            isCancelable = false
        }
        //TODO RETURN INFLATE LAYOUT LOADER
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}