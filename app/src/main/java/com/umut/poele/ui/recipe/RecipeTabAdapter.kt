package com.umut.poele.ui.recipe

import com.umut.poele.R
import com.umut.poele.data.RecipeDataSource
import com.umut.poele.databinding.ItemRecipeCategoryBinding
import com.umut.poele.model.FoodCategory
import com.umut.poele.ui.base.BaseAdapter

class RecipeTabAdapter(
    private val dataset: List<FoodCategory>, private val vm: HomeRecipeViewModel
) : BaseAdapter<ItemRecipeCategoryBinding, FoodCategory>(dataset, R.layout.item_recipe_category) {

    override fun bind(binding: ItemRecipeCategoryBinding, item: FoodCategory) {
        binding.apply {
            adapterRecipe = RecipeListAdapter(RecipeDataSource().loadRecipe(), vm)
        }
    }
}
