package com.umut.poele.ui.recipe

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.poele.R
import com.umut.poele.data.FoodCategoryDataSource
import com.umut.poele.databinding.FragmentHomeRecipeBinding
import com.umut.poele.ui.base.BaseFragment

class HomeRecipeFragment : BaseFragment<FragmentHomeRecipeBinding, HomeRecipeViewModel>(
    R.layout.fragment_home_recipe
) {

    override val vm: HomeRecipeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel = vm
            viewpagerRecipeCategory.adapter = RecipeTabAdapter(
                FoodCategoryDataSource().loadFoodCategory(), vm
            )
        }
        TabLayoutMediator(binding.tabRecipeCategory, binding.viewpagerRecipeCategory) { tab, position ->
            tab.text = FoodCategoryDataSource().loadFoodCategory()[position].name
        }.attach()
    }
}
