package com.umut.poele.ui.search

import com.umut.poele.R
import com.umut.poele.databinding.ListSearchRecipeBinding
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseAdapter

class SearchRecipeAdapter(
    dataset: List<RecipeBasic>,
    private val vm: SearchViewModel)
    : BaseAdapter<ListSearchRecipeBinding, RecipeBasic>(
    dataset, R.layout.list_search_recipe
) {

    override fun bind(binding: ListSearchRecipeBinding, item: RecipeBasic) {
        binding.apply {
            recipe = item
            cardRecipe.setOnClickListener {
                vm.onRecipeClicked(item)
            }
        }
    }
}
