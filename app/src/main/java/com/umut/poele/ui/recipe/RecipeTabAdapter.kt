package com.umut.poele.ui.recipe

import android.util.Log
import com.umut.poele.R
import com.umut.poele.data.source.local.entity.RecipeCategoryEntity
import com.umut.poele.data.source.local.entity.RecipeEntity
import com.umut.poele.databinding.ItemRecipeCategoryBinding
import com.umut.poele.domain.model.RecipeBasic
import com.umut.poele.ui.base.BaseAdapter

class RecipeTabAdapter(
    private val dataset: List<RecipeCategoryEntity>, private val vm: HomeRecipeViewModel, private val recipeList: List<List<RecipeBasic>>
) : BaseAdapter<ItemRecipeCategoryBinding, RecipeCategoryEntity>(dataset, R.layout.item_recipe_category) {

    override fun bind(binding: ItemRecipeCategoryBinding, item: RecipeCategoryEntity) {
        binding.apply {

            val index = dataset.indexOf(item)
            Log.i("umutcan", "index: $index")
            recipeList.forEach{

                Log.i("umutcan", "recipeList: ${it.first().title}")
            }

            adapterRecipe = RecipeListAdapter(recipeList[index], vm)
//            val adapter = ListRecipeAdapter{
//                vm.onRecipeClicked(it)
//            }
//
//            recyclerRecipe.adapter = adapter
//
//            vm.
        }
    }

    fun getHighlightedRecipe(item: RecipeBasic) {

    }
}
