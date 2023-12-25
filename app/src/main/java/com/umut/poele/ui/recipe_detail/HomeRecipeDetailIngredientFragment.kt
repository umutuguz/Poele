package com.umut.poele.ui.recipe_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.domain.model.RecipeDataSource
import com.umut.poele.databinding.FragmentHomeRecipeDetailIngredientBinding
import com.umut.poele.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRecipeDetailIngredientFragment :
    BaseFragment<FragmentHomeRecipeDetailIngredientBinding, HomeRecipeDetailViewModel>(
        R.layout.fragment_home_recipe_detail_ingredient
    ) {

    override val vm: HomeRecipeDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerIngredient
        binding.apply {
            adapter = IngredientAdapter(RecipeDataSource().loadRecipe()[0].ingredients)
        }
    }
}
