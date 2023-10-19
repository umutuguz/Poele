package com.umut.poele.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import com.umut.poele.BR
import com.umut.poele.util.Constants
import com.umut.poele.util.NavigationCommand

abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel>(
    private val layoutId: Int
) : Fragment() {

    private var hasBottomSheetOnScreen: Boolean = false

    private var _binding: B? = null
    val binding get() = _binding!!

    protected abstract val vm: VM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            inflater, layoutId, container, false
        )

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.viewModel, vm)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNavigation()
        observeBottomSheetState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeNavigation() {
        vm.navigation.observeNonNull(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { navigationCommand ->
                handleNavigation(navigationCommand)
            }
        }
    }
    private fun observeBottomSheetState() {
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Boolean>(
            Constants.KEY_DISMISS
        )?.observe(viewLifecycleOwner) {
            hasBottomSheetOnScreen = !it
        }
    }

    private fun handleNavigation(navigationCommand: NavigationCommand) {
        when (navigationCommand) {
            is NavigationCommand.ToDirection -> {
                if (navigationCommand.isBottomSheet) {
                    if (!hasBottomSheetOnScreen){
                        findNavController().navigate(navigationCommand.directions)
                        hasBottomSheetOnScreen = true
                    }
                }
                else {
                    findNavController().navigate(navigationCommand.directions)
                }
            }
            is NavigationCommand.Back -> findNavController().navigateUp()
        }
    }

}

fun <T> LiveData<T>.observeNonNull(owner: LifecycleOwner, observer: (t: T) -> Unit) {
    this.observe(
        owner
    ) {
        it?.let(observer)
    }
}
