package com.umut.poele.ui.recipe

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.poele.R
import com.umut.poele.databinding.FragmentHomeRecipeBinding
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.util.MealTypes
import com.umut.poele.util.toMealCategoryList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class HomeRecipeFragment : BaseFragment<FragmentHomeRecipeBinding, HomeRecipeViewModel>(
    R.layout.fragment_home_recipe
) {

    override val vm: HomeRecipeViewModel by activityViewModels()
    private val args: HomeRecipeFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewpagerRecipeCategory.adapter = RecipeTabAdapter(
                MealTypes.MAINCOURSE.toMealCategoryList(),
                vm,
                args.allRecipeList.toList()
            )

            TabLayoutMediator(binding.tabRecipeCategory, binding.viewpagerRecipeCategory) { tab, position ->
                tab.text = MealTypes.MAINCOURSE.toMealCategoryList()[position].title
                viewpagerRecipeCategory.setCurrentItem(args.clickedMealIndex, false)
            }.attach()
        }
    }

}
