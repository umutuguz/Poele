package com.umut.poele.ui.recipe

import com.umut.poele.R
import com.umut.poele.databinding.ListRecipeBinding
import com.umut.poele.model.Recipe
import com.umut.poele.ui.base.BaseAdapter

class RecipeListAdapter(private val dataset: List<Recipe>, private val vm: HomeRecipeViewModel) :
    BaseAdapter<ListRecipeBinding, Recipe>(dataset, R.layout.list_recipe) {

    override fun bind(binding: ListRecipeBinding, item: Recipe) {
        binding.apply {
            recipe = item
            viewModel = vm
            cardRecipe.setOnClickListener {
                vm.onRecipeClicked(item)
            }
        }
    }
}
