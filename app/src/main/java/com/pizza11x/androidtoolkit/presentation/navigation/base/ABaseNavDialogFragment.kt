package com.pizza11x.androidtoolkit.presentation.navigation.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import com.pizza11x.androidtoolkit.presentation.navigation.INavViewModel
import com.pizza11x.androidtoolkit.presentation.ui.base.ABaseDialogFragment

abstract class ABaseNavDialogFragment<DialogBinding : ViewDataBinding>(@LayoutRes layout: Int) :
    ABaseDialogFragment<DialogBinding>(layout) {
    /* VARIABLES */
    protected abstract val viewModel: INavViewModel
}
