package com.umut.poele.ui.base

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.umut.poele.util.Constant
import com.umut.poele.util.NavigationCommand

abstract class BaseBottomSheetFragment<T : ViewDataBinding, VM : BaseViewModel>(
    private val layoutId: Int
) : BottomSheetDialogFragment() {

    private var hasBottomSheetOnScreen: Boolean = false
    private var _binding: T? = null
    val binding get() = _binding!!
    protected abstract val vm: VM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        findNavController().previousBackStackEntry?.savedStateHandle?.set(Constant.KEY_DISMISS, false)
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNavigation()
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        findNavController().previousBackStackEntry?.savedStateHandle?.set(Constant.KEY_DISMISS, true)
    }

    private fun observeNavigation() {
        vm.navigation.observeNonNull(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { navigationCommand ->
                handleNavigation(navigationCommand)
            }
        }
    }

    private fun handleNavigation(navigationCommand: NavigationCommand) {
        when (navigationCommand) {
            is NavigationCommand.ToDirection -> {
                if (navigationCommand.isBottomSheet) {
                    if (!hasBottomSheetOnScreen) {
                        findNavController().navigate(navigationCommand.directions)
                        hasBottomSheetOnScreen = true
                    }
                }
                else {
                    findNavController().navigate(navigationCommand.directions)
                }
            }

            is NavigationCommand.Back -> {
                findNavController().navigateUp()
            }
        }
    }

}
