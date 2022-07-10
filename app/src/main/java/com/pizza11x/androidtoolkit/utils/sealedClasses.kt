package com.pizza11x.androidtoolkit.utils

import android.content.Intent
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.pizza11x.androidtoolkit.domain.models.IUiModel

/* LOADING */
sealed class LoadingStatus
object Loading : LoadingStatus()
object Completed : LoadingStatus()
object Failed : LoadingStatus()

/* Navigation */
sealed class NavigationCommand{
    object GoBack : NavigationCommand()
    object GoToStartDestination : NavigationCommand()

    data class GoTo(@IdRes val resID: Int, val arguments: Bundle = bundleOf()) : NavigationCommand()
    data class OpenBottomSheet(val bottomSheet: BottomSheetDialogFragment, val tag: String = bottomSheet.javaClass.simpleName) : NavigationCommand()
    data class OpenActivity(val intent: Intent, val bundle: Bundle = bundleOf(), val closeCurrentActivity: Boolean = false) : NavigationCommand()
    data class OpenDialog(val uiModel: IUiModel) : NavigationCommand()

}
