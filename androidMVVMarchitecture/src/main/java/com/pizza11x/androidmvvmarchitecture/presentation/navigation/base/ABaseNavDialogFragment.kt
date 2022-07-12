package com.pizza11x.androidmvvmarchitecture.presentation.navigation.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.pizza11x.androidmvvmarchitecture.presentation.ui.base.ABaseDialogFragment
import com.pizza11x.androidmvvmarchitecture.presentation.viewmodels.base.INavViewModel

abstract class ABaseNavDialogFragment<DialogBinding : ViewDataBinding>(@LayoutRes layout: Int) :
    ABaseDialogFragment<DialogBinding>(layout) {
    /* VARIABLES */
    protected abstract val viewModel: INavViewModel
}
