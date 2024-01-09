package com.umut.poele.ui.recipe

import android.util.Log
import com.umut.poele.R
import com.umut.poele.databinding.ItemRecipeCategoryBinding
import com.umut.poele.domain.model.CategoryList
import com.umut.poele.domain.model.MealCategory
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseAdapter

class RecipeTabAdapter(
    private val dataset: List<MealCategory>,
    private val vm: HomeRecipeViewModel,
    private val recipeList: List<CategoryList>
) : BaseAdapter<ItemRecipeCategoryBinding, MealCategory>(dataset, R.layout.item_recipe_category) {

    override fun bind(binding: ItemRecipeCategoryBinding, item: MealCategory) {
        binding.apply {
            val index = dataset.indexOf(item)

            adapterRecipe = RecipeListAdapter(recipeList[index].recipeList, vm)
        }
    }

}
