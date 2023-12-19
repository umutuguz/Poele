package com.umut.poele.ui.recipe

import android.util.Log
import com.umut.poele.R
import com.umut.poele.database.category.RecipeCategory
import com.umut.poele.database.recipe.Recipe
import com.umut.poele.databinding.ItemRecipeCategoryBinding
import com.umut.poele.ui.base.BaseAdapter

class RecipeTabAdapter(
    dataset: List<RecipeCategory>, private val vm: HomeRecipeViewModel, private val recipeList: List<Recipe>
) : BaseAdapter<ItemRecipeCategoryBinding, RecipeCategory>(dataset, R.layout.item_recipe_category) {

    override fun bind(binding: ItemRecipeCategoryBinding, item: RecipeCategory) {
        binding.apply {
            Log.i("umutcan", "RecipeTabAdapter ${recipeList.size}")

            adapterRecipe = RecipeListAdapter(recipeList, vm)
        }
    }
}
