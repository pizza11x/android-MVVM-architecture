package com.pizza11x.androidmvvmarchitecture.presentation.navigation

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.pizza11x.androidmvvmarchitecture.presentation.ui.base.ABaseFragment
import com.pizza11x.androidmvvmarchitecture.presentation.viewmodels.base.ABaseNavViewModel
import com.pizza11x.androidmvvmarchitecture.utils.extensions.observeOnce

abstract class ANavFragment<FragmentBinding : ViewDataBinding>(@LayoutRes layout: Int) :
    ABaseFragment<FragmentBinding>(layout) {

    /* VARIABLES */
    abstract override val viewModel: ABaseNavViewModel

    /* FRAGMENT FUN */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navLiveData.observeOnce(viewLifecycleOwner) {
            when (it) {
                is NavigationCommand.OpenActivity -> startActivity(it.intent, it.bundle)
                is NavigationCommand.GoTo -> goTo(it.resID, arguments = it.arguments)
                is NavigationCommand.GoBack -> goBack()
                is NavigationCommand.GoToStartDestination -> goToStartDestination()
                is NavigationCommand.OpenBottomSheet -> it.bottomSheet.show(
                    parentFragmentManager,
                    it.tag
                )
                is NavigationCommand.OpenDialog -> it.dialog.show(parentFragmentManager, it.tag)
                is NavigationCommand.BackPressed -> backPressed()
                else -> { /* DO NOTHING */
                }
            }
        }
    }

    /* PROTECTED FUN */
    protected fun goTo(
        @IdRes resID: Int,
        arguments: Bundle? = null,
        options: NavOptions? = null
    ) = findNavController().navigate(resID, arguments, options)

    protected fun goUpTo(@IdRes resID: Int) =
        goTo(resID, options = NavOptions.Builder().setPopUpTo(resID, true).build())

    protected fun goBack() = findNavController().popBackStack()

    protected fun goToStartDestination() = goUpTo(findNavController().graph.startDestinationId)

    open fun backPressed() = activity?.onBackPressed()

}