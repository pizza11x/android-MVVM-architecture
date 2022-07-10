package com.pizza11x.androidMVVMarchitecture.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment

abstract class ABaseDialogFragment<DialogBinding : ViewDataBinding>(
    @LayoutRes
    private val layout: Int
) : DialogFragment() {

    /* VARIABLES */
    protected lateinit var binding: DialogBinding

    /* DIALOG FRAGMENT FUN */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.lifecycleOwner = viewLifecycleOwner
        isCancelable = false
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.let {
            it.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    companion object {
        const val TAG = "BASE_DIALOG"
    }
}