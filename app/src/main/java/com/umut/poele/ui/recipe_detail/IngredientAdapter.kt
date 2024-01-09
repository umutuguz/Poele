package com.umut.poele.ui.recipe_detail

import com.umut.poele.R
import com.umut.poele.databinding.ListRecipeIngredientBinding
import com.umut.poele.domain.model.Supply
import com.umut.poele.ui.base.BaseAdapter
import com.umut.poele.ui.base.BaseListAdapter

class IngredientAdapter :
    BaseListAdapter<ListRecipeIngredientBinding, Supply>(R.layout.list_recipe_ingredient) {


    override fun bind(binding: ListRecipeIngredientBinding, item: Supply) {
        binding.apply {
            ingredient = item
        }
    }

}
