package com.umut.poele.ui.recipe

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.umut.poele.R
import com.umut.poele.data.RecipeDataSource
import com.umut.poele.data.RecipeTabDataSource
import com.umut.poele.databinding.FragmentHomeRecipeBinding
import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseFragment
import com.umut.poele.ui.base.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRecipeFragment :
    BaseFragment<FragmentHomeRecipeBinding, BaseViewModel>(R.layout.fragment_home_recipe, true) {

    override val vm: HomeRecipeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            adapterRecipeTab = RecipeTabAdapter(RecipeTabDataSource().loadRecipeTab(), vm)
            viewModel = vm
            viewpagerRecipeCategory.adapter = RecipeTabAdapter(RecipeTabDataSource()
                .loadRecipeTab(), vm)
        }
        TabLayoutMediator(binding.tabRecipeCategory, binding.viewpagerRecipeCategory) { tab,
                                                                                        position ->
            tab.text = RecipeDataSource().loadRecipe()[position].category

        }.attach()
    }

}
