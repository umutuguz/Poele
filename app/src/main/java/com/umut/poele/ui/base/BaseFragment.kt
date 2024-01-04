package com.umut.poele.ui.base

import android.os.Bundle
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
import com.umut.poele.data.source.local.entity.MenuCardEntity
import com.umut.poele.domain.model.MenuCard
import com.umut.poele.util.Constant
import com.umut.poele.util.Meals
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
            Constant.KEY_DISMISS
        )?.observe(viewLifecycleOwner) {
            hasBottomSheetOnScreen = !it
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

            is NavigationCommand.Back -> findNavController().navigateUp()
        }
    }

    fun loadMenuCardModel(menuCardList: List<MenuCardEntity>): List<MenuCard> {
        return if (menuCardList.isNotEmpty()) {
            listOf(
                MenuCard(
                    Meals.BREAKFAST,
                    menuCardList[0].chefName,
                    menuCardList[0].primaryMealBreakfast,
                    menuCardList[0].secondaryMealBreakfast,
                    menuCardList[0].tertiaryMealBreakfast
                ),
                MenuCard(
                    Meals.BRUNCH,
                    menuCardList[0].chefName,
                    menuCardList[0].primaryMealBrunch,
                    menuCardList[0].secondaryMealBrunch,
                    menuCardList[0].tertiaryMealBrunch
                ),
                MenuCard(
                    Meals.LUNCH,
                    menuCardList[0].chefName,
                    menuCardList[0].primaryMealLunch,
                    menuCardList[0].secondaryMealLunch,
                    menuCardList[0].tertiaryMealLunch
                ),
                MenuCard(
                    Meals.DINNER,
                    menuCardList[0].chefName,
                    menuCardList[0].primaryMealDinner,
                    menuCardList[0].secondaryMealDinner,
                    menuCardList[0].tertiaryMealDinner
                ),
            )
        }
        else {
            listOf()
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
