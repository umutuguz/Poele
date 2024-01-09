package com.umut.poele.ui.recipe_detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.umut.poele.R
import com.umut.poele.databinding.FragmentHomeRecipeDetailIngredientBinding
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRecipeDetailIngredientFragment(private var clickedRecipe: RecipeBasic) :
    BaseFragment<FragmentHomeRecipeDetailIngredientBinding, HomeRecipeDetailViewModel>(
        R.layout.fragment_home_recipe_detail_ingredient
    ) {

    override val vm: HomeRecipeDetailViewModel by viewModels()
    private val adapter = IngredientAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            recipe = clickedRecipe

            adapter.setHasStableIds(true)
            recyclerIngredient.adapter = adapter
            adapter.submitList(clickedRecipe.ingredients)

            vm.recipeInfoLiveData.observe(viewLifecycleOwner) {
                adapter.submitList(it.ingredients)
                recipe = it
                clickedRecipe = it
            }

            buttonAdd.setOnClickListener {
                vm.increaseServings(clickedRecipe)
            }
            buttonRemove.setOnClickListener {
                vm.decreaseServings(clickedRecipe)
            }
        }
    }

}
