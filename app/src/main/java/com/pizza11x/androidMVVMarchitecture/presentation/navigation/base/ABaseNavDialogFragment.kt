package com.pizza11x.androidMVVMarchitecture.presentation.navigation.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.pizza11x.androidMVVMarchitecture.presentation.viewmodels.base.INavViewModel
import com.pizza11x.androidMVVMarchitecture.presentation.ui.base.ABaseDialogFragment

abstract class ABaseNavDialogFragment<DialogBinding : ViewDataBinding>(@LayoutRes layout: Int) :
    ABaseDialogFragment<DialogBinding>(layout) {
    /* VARIABLES */
    protected abstract val viewModel: INavViewModel
}
