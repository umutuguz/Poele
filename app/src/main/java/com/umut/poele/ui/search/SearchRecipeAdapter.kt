package com.umut.poele.ui.search

import com.umut.poele.R
import com.umut.poele.databinding.ListSearchRecipeBinding
import com.umut.poele.domain.model.RecipeModel
import com.umut.poele.ui.base.BaseAdapter

class SearchRecipeAdapter(private val dataset: List<RecipeModel>, private val vm: SearchViewModel) : BaseAdapter<ListSearchRecipeBinding, RecipeModel>(
    dataset, R.layout.list_search_recipe
) {

    override fun bind(binding: ListSearchRecipeBinding, item: RecipeModel) {
        binding.apply {
            recipeModel = item
            cardRecipe.setOnClickListener {
                vm.onRecipeClicked(item)
            }
        }
    }
}
