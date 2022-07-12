package com.pizza11x.androidmvvmarchitecture.presentation.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.pizza11x.androidmvvmarchitecture.utils.extensions.bindLayout

abstract class ABaseActivity<ActivityBinding : ViewDataBinding>(@LayoutRes private val layout: Int) :
    AppCompatActivity() {

    /* VARIABLES */
    protected lateinit var binding: ActivityBinding
    abstract val viewModel: ViewModel

    /* ACTIVITY FUN */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindLayout(layout)
    }
}