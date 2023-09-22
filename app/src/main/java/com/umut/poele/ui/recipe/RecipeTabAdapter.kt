package com.umut.poele.ui.recipe

import com.umut.poele.R
import com.umut.poele.data.RecipeDataSource
import com.umut.poele.data.RecipeTabDataSource
import com.umut.poele.databinding.ItemRecipeCategoryBinding
import com.umut.poele.model.Recipe
import com.umut.poele.model.RecipeTab
import com.umut.poele.ui.base.BaseAdapter

class RecipeTabAdapter(private val dataset: List<RecipeTab>,
    private val vm: HomeRecipeViewModel):
    BaseAdapter<ItemRecipeCategoryBinding,
        RecipeTab>(dataset, R.layout.item_recipe_category){

    override fun bind(binding: ItemRecipeCategoryBinding, item: RecipeTab) {
        binding.apply {
            adapterRecipe = RecipeListAdapter(RecipeDataSource().loadRecipe(),
                vm, vm)
            listRecipe = RecipeDataSource()
        }
    }


}
