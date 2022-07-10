package com.pizza11x.androidMVVMarchitecture.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pizza11x.androidMVVMarchitecture.presentation.viewmodels.base.ABaseViewModel
import com.pizza11x.androidMVVMarchitecture.utils.extensions.bindLayout

abstract class ABaseBottomSheetDialogFragment<SheetBinding : ViewDataBinding>(@LayoutRes private val layout: Int) :
    BottomSheetDialogFragment() {

    /* VARIABLES */
    protected lateinit var binding: SheetBinding
    abstract val viewModel: ABaseViewModel

    /* FRAGMENT FUN */
    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = bindLayout(inflater, layout, container)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewBinding()
    }

    /* ABSTRACT FUN */
    abstract fun initViewBinding()
}