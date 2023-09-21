package com.umut.poele.ui.recipe

import com.umut.poele.R
import com.umut.poele.databinding.ListRecipeBinding
import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseAdapter

class RecipeListAdapter(private val dataset: List<Recipe>) :
    BaseAdapter<ListRecipeBinding, Recipe>(dataset, R.layout.fragment_home_recipe) {

    override fun bind(binding: ListRecipeBinding, item: Recipe) {
        binding.apply {
            recipe = item
        }
    }
}
