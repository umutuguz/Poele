package com.umut.poele.ui.recipe

import android.util.Log
import com.umut.poele.R
import com.umut.poele.data.source.local.entity.RecipeCategoryEntity
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.databinding.ItemRecipeCategoryBinding
import com.umut.poele.ui.base.BaseAdapter

class RecipeTabAdapter(
    dataset: List<RecipeCategoryEntity>, private val vm: HomeRecipeViewModel, private val recipeList: List<RecipeEntity>
) : BaseAdapter<ItemRecipeCategoryBinding, RecipeCategoryEntity>(dataset, R.layout.item_recipe_category) {

    override fun bind(binding: ItemRecipeCategoryBinding, item: RecipeCategoryEntity) {
        binding.apply {
            Log.i("umutcan", "RecipeTabAdapter ${recipeList.size}")

            adapterRecipe = RecipeListAdapter(recipeList, vm)
//            val adapter = ListRecipeAdapter{
//                vm.onRecipeClicked(it)
//            }
//
//            recyclerRecipe.adapter = adapter
//
//            vm.
        }
    }
}
