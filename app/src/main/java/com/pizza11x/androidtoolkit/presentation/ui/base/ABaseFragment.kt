package com.pizza11x.androidtoolkit.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.pizza11x.androidtoolkit.presentation.viewmodel.base.ABaseViewModel
import com.pizza11x.androidtoolkit.utils.extensions.bindLayout

abstract class ABaseFragment<FragmentBinding : ViewDataBinding>(@LayoutRes private val layout: Int) :
    Fragment() {

    /* VARIABLES */
    protected lateinit var binding: FragmentBinding
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

        viewReady()
    }

    /* ABSTRACT FUN */
    abstract fun viewReady()
}