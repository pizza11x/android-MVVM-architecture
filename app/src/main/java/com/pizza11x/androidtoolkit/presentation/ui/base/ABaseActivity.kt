package com.pizza11x.androidtoolkit.presentation.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.pizza11x.androidtoolkit.utils.bindLayout
import dagger.hilt.android.AndroidEntryPoint

abstract class ABaseActivity<BindingType : ViewDataBinding>(@LayoutRes private val layout: Int) :
    AppCompatActivity() {

    /* VARIABLES */
    protected lateinit var binding: BindingType
    abstract val viewModel: ViewModel

    /* ACTIVITY FUNCTION */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindLayout(layout)
    }
}