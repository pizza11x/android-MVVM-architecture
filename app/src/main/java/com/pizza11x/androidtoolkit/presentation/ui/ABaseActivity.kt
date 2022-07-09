package com.pizza11x.androidtoolkit.presentation.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.pizza11x.androidtoolkit.utils.bindLayout

abstract class ABaseActivity<BindingType : ViewDataBinding>(@LayoutRes private val layout: Int): AppCompatActivity() {

    protected lateinit var binding: BindingType
    abstract val viewModel : ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindLayout(layout)
    }
}