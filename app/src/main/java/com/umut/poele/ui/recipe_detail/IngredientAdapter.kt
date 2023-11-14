package com.umut.poele.ui.recipe_detail

import com.umut.poele.R
import com.umut.poele.databinding.ListRecipeIngredientBinding
import com.umut.poele.model.Supply
import com.umut.poele.ui.base.BaseAdapter

class IngredientAdapter(private val dataset: List<Supply>) :
    BaseAdapter<ListRecipeIngredientBinding, Supply>(dataset, R.layout.list_recipe_ingredient) {

    override fun bind(binding: ListRecipeIngredientBinding, item: Supply) {
        binding.apply {
            ingredient = item
        }
    }
}
