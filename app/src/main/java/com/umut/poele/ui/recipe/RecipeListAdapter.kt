package com.umut.poele.ui.recipe

import com.umut.poele.R
import com.umut.poele.databinding.ListRecipeBinding
import com.umut.poele.model.FoodCategory
import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.ui.base.BaseViewModel
import com.umut.poele.util.RecipeListener

class RecipeListAdapter(private val dataset: List<Recipe>,
                        private val recipeClickListener: RecipeListener,
                        private val vm: HomeRecipeViewModel) :
    BaseAdapter<ListRecipeBinding, Recipe>(dataset, R.layout.list_recipe) {



    override fun bind(binding: ListRecipeBinding, item: Recipe) {
        binding.apply {
            recipe = item
            listener = recipeClickListener
            viewModel = vm
        }
    }
}
