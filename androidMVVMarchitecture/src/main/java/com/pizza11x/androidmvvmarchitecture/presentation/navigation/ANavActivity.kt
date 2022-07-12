package com.pizza11x.androidmvvmarchitecture.presentation.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.pizza11x.androidmvvmarchitecture.presentation.ui.base.ABaseActivity
import com.pizza11x.androidmvvmarchitecture.presentation.viewmodels.base.ABaseNavViewModel
import com.pizza11x.androidmvvmarchitecture.utils.extensions.observeOnce

abstract class ANavActivity<ActivityBinding : ViewDataBinding>(@LayoutRes private val layout: Int) :
    ABaseActivity<ActivityBinding>(layout) {
    /* VARIABLES */
    abstract override val viewModel: ABaseNavViewModel
    protected abstract val currentNavHostID: Int

    /* ACTIVITY FUN */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navLiveData.observeOnce(this) {
            when (it) {
                is NavigationCommand.OpenActivity -> {
                    startActivity(it.intent, it.bundle)
                    if (it.closeCurrentActivity) {
                        finish()
                    }
                }
                is NavigationCommand.GoTo -> goTo(it.resID, arguments = it.arguments)
                is NavigationCommand.GoBack -> goBack()
                is NavigationCommand.GoToStartDestination -> goToStartDestination()
                is NavigationCommand.OpenBottomSheet -> it.bottomSheet.show(supportFragmentManager, it.tag)
                is NavigationCommand.OpenDialog -> it.dialog.show(supportFragmentManager, it.tag)
                else -> { /* DO NOTHING */ }
            }
        }
    }

    /* PROTECTED FUN */
    protected fun goTo(
        @IdRes resID: Int,
        navHostID: Int = currentNavHostID,
        arguments: Bundle? = null,
        options: NavOptions? = null
    ) = findNavController(navHostID).navigate(resID, arguments, options)

    protected fun goUpTo(@IdRes resID: Int) =
        goTo(resID, options = NavOptions.Builder().setPopUpTo(resID, true).build())

    protected fun goBack(navHostID: Int = currentNavHostID) =
        findNavController(navHostID).popBackStack()

    protected fun goToStartDestination(navHostID: Int = currentNavHostID) =
        goUpTo(findNavController(navHostID).graph.startDestinationId)

}