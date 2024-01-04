package com.umut.poele.ui.recipe

import com.umut.poele.R
import com.umut.poele.databinding.ListRecipeBinding
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseAdapter

class RecipeListAdapter(dataset: List<RecipeBasic>, private val vm: HomeRecipeViewModel) :
    BaseAdapter<ListRecipeBinding, RecipeBasic>(dataset, R.layout.list_recipe) {

    override fun bind(binding: ListRecipeBinding, item: RecipeBasic) {
        binding.apply {
            recipe = item
            cardRecipe.setOnClickListener {
                vm.onRecipeClicked(item)
            }
        }
    }
}
